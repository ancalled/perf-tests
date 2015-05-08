/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.examples;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.DirectBuffer;

public class GroupSizeEncodingDecoder
{
    private DirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public GroupSizeEncodingDecoder wrap(final DirectBuffer buffer, final int offset, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingVersion = actingVersion;
        return this;
    }

    public int size()
    {
        return 3;
    }

    public static int blockLengthNullValue()
    {
        return 65535;
    }

    public static int blockLengthMinValue()
    {
        return 0;
    }

    public static int blockLengthMaxValue()
    {
        return 65534;
    }

    public int blockLength()
    {
        return CodecUtil.uint16Get(buffer, offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static short numInGroupNullValue()
    {
        return (short)255;
    }

    public static short numInGroupMinValue()
    {
        return (short)0;
    }

    public static short numInGroupMaxValue()
    {
        return (short)254;
    }

    public short numInGroup()
    {
        return CodecUtil.uint8Get(buffer, offset + 2);
    }

}
