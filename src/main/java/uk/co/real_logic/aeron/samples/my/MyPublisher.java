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

import uk.co.real_logic.aeron.Aeron;
import uk.co.real_logic.aeron.Publication;
import uk.co.real_logic.aeron.driver.MediaDriver;
import uk.co.real_logic.aeron.samples.SampleConfiguration;
import uk.co.real_logic.aeron.samples.my.domain.MDIncRefreshTrades;
import uk.co.real_logic.aeron.samples.my.sbe.fix.MarketDataIncrementalRefreshTradesEncoder;
import uk.co.real_logic.aeron.samples.my.sbe.fix.MessageHeaderEncoder;
import uk.co.real_logic.agrona.CloseHelper;
import uk.co.real_logic.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Basic Aeron publisher application
 */
public class MyPublisher {

    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;
    private static final long NUMBER_OF_MESSAGES = SampleConfiguration.NUMBER_OF_MESSAGES;
    private static final long LINGER_TIMEOUT_MS = SampleConfiguration.LINGER_TIMEOUT_MS;

    private static final boolean EMBEDDED_MEDIA_DRIVER = SampleConfiguration.EMBEDDED_MEDIA_DRIVER;
    private static final UnsafeBuffer BUFFER = new UnsafeBuffer(ByteBuffer.allocateDirect(256));


    private static final MessageHeaderEncoder MESSAGE_HEADER = new MessageHeaderEncoder();
    private static final MarketDataIncrementalRefreshTradesEncoder MDINCREF = new MarketDataIncrementalRefreshTradesEncoder();


    public static void main(final String[] args) throws Exception {
        System.out.println("Publishing to " + CHANNEL + " on stream Id " + STREAM_ID);

        final MediaDriver driver = EMBEDDED_MEDIA_DRIVER ? MediaDriver.launchEmbedded() : null;
        final Aeron.Context ctx = new Aeron.Context();
        if (EMBEDDED_MEDIA_DRIVER) {
            ctx.dirName(driver.contextDirName());
        }

        Random r = new Random();

        int idx = 0;
        List<MDIncRefreshTrades> events =
                IntStream.range(0, 1000)
                        .mapToObj(i -> new MDIncRefreshTrades(r.nextInt(20), 1000 + r.nextInt(500) / 10, r.nextInt(50) * 10000))
                        .collect(Collectors.toList());


        try (final Aeron aeron = Aeron.connect(ctx);
             final Publication publication = aeron.addPublication(CHANNEL, STREAM_ID)) {
            for (int i = 0; i < NUMBER_OF_MESSAGES; i++) {

                MDIncRefreshTrades ti = events.get(idx);
                int size = encode(ti, MDINCREF, BUFFER, 0);

                System.out.println("offering " + i + "/" + NUMBER_OF_MESSAGES);
                final long result = publication.offer(BUFFER, 0, size);

                if (result < 0L) {
                    System.out.println("Something bad!");
                }

                idx = idx < events.size() - 1 ? idx + 1 : 0;

//                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                TimeUnit.MILLISECONDS.sleep(300);
            }

            System.out.println("Done sending.");

            if (0 < LINGER_TIMEOUT_MS) {
                System.out.println("Lingering for " + LINGER_TIMEOUT_MS + " milliseconds...");
                Thread.sleep(LINGER_TIMEOUT_MS);
            }
        }

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

        srcOffset += MDINCREF.size();
        return srcOffset;
    }


}
