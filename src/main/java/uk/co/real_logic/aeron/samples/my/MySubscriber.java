/*
 * Copyright 2014 - 2015 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.real_logic.aeron.samples.my;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslatorThreeArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import uk.co.real_logic.aeron.Aeron;
import uk.co.real_logic.aeron.Subscription;
import uk.co.real_logic.aeron.common.concurrent.logbuffer.DataHandler;
import uk.co.real_logic.aeron.driver.MediaDriver;
import uk.co.real_logic.aeron.samples.SampleConfiguration;
import uk.co.real_logic.aeron.samples.SamplesUtil;
import uk.co.real_logic.aeron.samples.my.disruptor.Event;
import uk.co.real_logic.aeron.samples.my.domain.MDIncRefreshTrades;
import uk.co.real_logic.aeron.samples.my.domain.NewOrder;
import uk.co.real_logic.aeron.samples.my.sbe.fix.MarketDataIncrementalRefreshTradesDecoder;
import uk.co.real_logic.aeron.samples.my.sbe.fix.MessageHeaderDecoder;
import uk.co.real_logic.aeron.samples.my.sbe.fix.NewOrderDecoder;
import uk.co.real_logic.agrona.CloseHelper;
import uk.co.real_logic.agrona.DirectBuffer;
import uk.co.real_logic.agrona.concurrent.SigInt;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Basic Aeron subscriber application
 */
public class MySubscriber {

    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;
    private static final int FRAGMENT_COUNT_LIMIT = SampleConfiguration.FRAGMENT_COUNT_LIMIT;
    private static final boolean EMBEDDED_MEDIA_DRIVER = SampleConfiguration.EMBEDDED_MEDIA_DRIVER;


    public static final int RING_BUFFER_SIZE = 1024;

    private final MarketDataIncrementalRefreshTradesDecoder MDINC_DECODER = new MarketDataIncrementalRefreshTradesDecoder();
    private final NewOrderDecoder NEWORDER_DECODER = new NewOrderDecoder();

    private final MessageHeaderDecoder READ_ONLY_MESSAGE_HEADER = new MessageHeaderDecoder();
    private RingBuffer<Event> ringBuffer;


    public MySubscriber() {
        Executor executor = Executors.newCachedThreadPool();
        Disruptor<Event> disruptor = new Disruptor<>(Event::new, RING_BUFFER_SIZE, executor);
        final EventHandler<Event> handler = (ev, sequence, endOfBatch) -> {
            if (ev.value != null) {
                if (ev.value instanceof MDIncRefreshTrades) {
                    System.out.println("Got trade info");
                    MDIncRefreshTrades ti = (MDIncRefreshTrades) ev.value;
                    System.out.println("\t" + ti);
                }
            }

        };
        disruptor.handleEventsWith(handler);
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();

        startAeron();
    }


    public void startAeron() {

        System.out.println("Subscribing to " + CHANNEL + " on stream Id " + STREAM_ID);
        final MediaDriver driver = EMBEDDED_MEDIA_DRIVER ? MediaDriver.launchEmbedded() : null;

        final Aeron.Context ctx = new Aeron.Context()
                .newConnectionHandler(SamplesUtil::printNewConnection)
                .inactiveConnectionHandler(SamplesUtil::printInactiveConnection);

        if (EMBEDDED_MEDIA_DRIVER) {
            ctx.dirName(driver.contextDirName());
        }

        final DataHandler dataHandler =
                (buffer, offset, length, header) -> ringBuffer.publishEvent(TRANSLATOR, buffer, offset, length);

        final AtomicBoolean running = new AtomicBoolean(true);
        SigInt.register(() -> running.set(false));

        try (final Aeron aeron = Aeron.connect(ctx);
             final Subscription subscription = aeron.addSubscription(CHANNEL, STREAM_ID, dataHandler)) {
            // run the subscriber thread from here
            SamplesUtil.subscriberLoop(FRAGMENT_COUNT_LIMIT, running).accept(subscription);
            System.out.println("Shutting down...");
        }

        CloseHelper.quietClose(driver);
    }



    private final EventTranslatorThreeArg<Event, DirectBuffer, Integer, Integer> TRANSLATOR =
            (event, sequence, buffer, offset, length) -> {
                final byte[] data = new byte[length];
                buffer.getBytes(offset, data);

                READ_ONLY_MESSAGE_HEADER.wrap(buffer, offset, 0).size();
                final int actingBlockLength = READ_ONLY_MESSAGE_HEADER.blockLength();
                final int schemaId = READ_ONLY_MESSAGE_HEADER.schemaId();
                final int actingVersion = READ_ONLY_MESSAGE_HEADER.version();
                offset += READ_ONLY_MESSAGE_HEADER.size();

                if (READ_ONLY_MESSAGE_HEADER.templateId() == MDINC_DECODER.sbeTemplateId()) {
                    MDINC_DECODER.wrap(buffer, offset, actingBlockLength, actingVersion);

                    MDIncRefreshTrades ti = new MDIncRefreshTrades();
                    ti.deserialize(MDINC_DECODER);
                    event.setValue(ti);

                } else if (READ_ONLY_MESSAGE_HEADER.templateId() == NEWORDER_DECODER.sbeTemplateId()) {
                    NEWORDER_DECODER.wrap(buffer, offset, actingBlockLength, actingVersion);

                    NewOrder no = new NewOrder();
                    no.deserialize(NEWORDER_DECODER);
                    event.setValue(no);
                }
            };


    public static void main(final String[] args) throws Exception {
        MySubscriber subscriber = new MySubscriber();
        subscriber.startAeron();
    }


}
