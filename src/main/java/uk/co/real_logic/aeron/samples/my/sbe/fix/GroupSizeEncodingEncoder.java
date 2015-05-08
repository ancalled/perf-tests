/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

public class GroupSizeEncodingEncoder
{
    private MutableDirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public GroupSizeEncodingEncoder wrap(final MutableDirectBuffer buffer, final int offset, final int actingVersion)
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
    public GroupSizeEncodingEncoder blockLength(final int value)
    {
        CodecUtil.uint16Put(buffer, offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
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
    public GroupSizeEncodingEncoder numInGroup(final short value)
    {
        CodecUtil.uint8Put(buffer, offset + 2, value);
        return this;
    }
}
