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
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import uk.co.real_logic.aeron.Aeron;
import uk.co.real_logic.aeron.Publication;
import uk.co.real_logic.aeron.driver.MediaDriver;
import uk.co.real_logic.aeron.samples.SampleConfiguration;
import uk.co.real_logic.aeron.samples.my.disruptor.Event;
import uk.co.real_logic.aeron.samples.my.domain.MDIncRefreshTrades;
import uk.co.real_logic.aeron.samples.my.sbe.fix.MarketDataIncrementalRefreshTradesEncoder;
import uk.co.real_logic.aeron.samples.my.sbe.fix.MessageHeaderEncoder;
import uk.co.real_logic.agrona.CloseHelper;
import uk.co.real_logic.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Basic Aeron publisher application
 */
public class MyPublisher {

    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;
    private static final int NUMBER_OF_MESSAGES = SampleConfiguration.NUMBER_OF_MESSAGES;
    private static final int NUMBER_OF_OBJECTS = 2048;
    private static final long LINGER_TIMEOUT_MS = SampleConfiguration.LINGER_TIMEOUT_MS;

    private static final boolean EMBEDDED_MEDIA_DRIVER = SampleConfiguration.EMBEDDED_MEDIA_DRIVER;
    private static final UnsafeBuffer BUFFER = new UnsafeBuffer(ByteBuffer.allocateDirect(2048));

    public static final int RING_BUFFER_SIZE = 1024;


    private static final MessageHeaderEncoder MESSAGE_HEADER = new MessageHeaderEncoder();
    private static final MarketDataIncrementalRefreshTradesEncoder MDINCREF_ENCODER =
            new MarketDataIncrementalRefreshTradesEncoder();

    private RingBuffer<Event> ringBuffer;
    private Publication publication;
    private MediaDriver driver;

    public MyPublisher() {

        Executor executor = Executors.newCachedThreadPool();
        Disruptor<Event> disruptor = new Disruptor<>(Event::new, RING_BUFFER_SIZE, executor);
        final EventHandler<Event> handler = (ev, sequence, endOfBatch) -> {
            if (ev.value instanceof MDIncRefreshTrades) {
                MDIncRefreshTrades md = (MDIncRefreshTrades) ev.value;
                System.out.println("Sending message: " + md);

                int size = encode(md, MDINCREF_ENCODER, BUFFER, 0);
                final long result = publication.offer(BUFFER, 0, size);
                if (result < 0L) {
                    System.out.println("Something bad!");
                }
            }

        };
        disruptor.handleEventsWith(handler);
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();

    }


    void startAeron() throws InterruptedException {
        driver = EMBEDDED_MEDIA_DRIVER ? MediaDriver.launchEmbedded() : null;
        final Aeron.Context ctx = new Aeron.Context();
        if (EMBEDDED_MEDIA_DRIVER) {
            ctx.dirName(driver.contextDirName());
        }

        try (final Aeron aeron = Aeron.connect(ctx)) {
            publication = aeron.addPublication(CHANNEL, STREAM_ID);


//            if (0 < LINGER_TIMEOUT_MS) {
//                System.out.println("Lingering for " + LINGER_TIMEOUT_MS + " milliseconds...");
//                Thread.sleep(LINGER_TIMEOUT_MS);
//            }
        }

    }

    void startQuotesProcess() {
        final EventTranslatorOneArg<Event, MDIncRefreshTrades> translator =
                (event, sequence, md) -> {
                    event.setValue(md);
                    System.out.println("We here");
                };
        List<MDIncRefreshTrades> messages = new Random().ints(NUMBER_OF_OBJECTS)
                .mapToObj(d -> new MDIncRefreshTrades(1, 100, 100))
//                .mapToObj(d -> new MDIncRefreshTrades(1, d, d))
                .collect(Collectors.toList());

        IntStream.range(0, NUMBER_OF_MESSAGES).forEach(i -> {
            final int l = i % NUMBER_OF_OBJECTS;
            ringBuffer.publishEvent(translator, messages.get(l));
            try {
//                TimeUnit.MILLISECONDS.sleep(300);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }

    public void closeDriver() {
        CloseHelper.quietClose(driver);
    }


    public static int encode(MDIncRefreshTrades ti, final MarketDataIncrementalRefreshTradesEncoder encoder,
                             final UnsafeBuffer directBuffer, final int bufferOffset) {
        int srcOffset = 0;
        MESSAGE_HEADER.wrap(directBuffer, bufferOffset, 0)
                .blockLength(encoder.sbeBlockLength())
                .templateId(encoder.sbeTemplateId())
                .schemaId(encoder.sbeSchemaId())
                .version(encoder.sbeSchemaVersion());

        srcOffset += MESSAGE_HEADER.size();

        encoder.wrap(directBuffer, srcOffset);

        ti.serialize(encoder);

        srcOffset += MDINCREF_ENCODER.size();
        return srcOffset;
    }


    public static void main(final String[] args) throws Exception {
        System.out.println("Publishing to " + CHANNEL + " on stream Id " + STREAM_ID);

        MyPublisher publisher = new MyPublisher();
        publisher.startAeron();
        publisher.startQuotesProcess();
        publisher.closeDriver();


    }


}
