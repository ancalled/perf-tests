/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.examples;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.DirectBuffer;

public class OptionalExtrasDecoder
{
    private DirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public OptionalExtrasDecoder wrap(final DirectBuffer buffer, final int offset, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingVersion = actingVersion;
        return this;
    }

    public int size()
    {
        return 1;
    }

    public boolean sunRoof()
    {
        return CodecUtil.uint8GetChoice(buffer, offset, 0);
    }


    public boolean sportsPack()
    {
        return CodecUtil.uint8GetChoice(buffer, offset, 1);
    }


    public boolean cruiseControl()
    {
        return CodecUtil.uint8GetChoice(buffer, offset, 2);
    }

}
