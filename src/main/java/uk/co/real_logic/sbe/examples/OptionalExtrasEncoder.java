/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.examples;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

public class OptionalExtrasEncoder
{
    private MutableDirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public OptionalExtrasEncoder wrap(final MutableDirectBuffer buffer, final int offset, final int actingVersion)
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

    public OptionalExtrasEncoder clear()
    {
        CodecUtil.uint8Put(buffer, offset, (short)0);
        return this;
    }

    public OptionalExtrasEncoder sunRoof(final boolean value)
    {
        CodecUtil.uint8PutChoice(buffer, offset, 0, value);
        return this;
    }

    public OptionalExtrasEncoder sportsPack(final boolean value)
    {
        CodecUtil.uint8PutChoice(buffer, offset, 1, value);
        return this;
    }

    public OptionalExtrasEncoder cruiseControl(final boolean value)
    {
        CodecUtil.uint8PutChoice(buffer, offset, 2, value);
        return this;
    }
}
