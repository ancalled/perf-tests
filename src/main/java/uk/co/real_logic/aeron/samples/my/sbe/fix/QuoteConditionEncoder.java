/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

public class QuoteConditionEncoder
{
    private MutableDirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public QuoteConditionEncoder wrap(final MutableDirectBuffer buffer, final int offset, final int actingVersion)
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

    public QuoteConditionEncoder clear()
    {
        CodecUtil.uint8Put(buffer, offset, (short)0);
        return this;
    }

    public QuoteConditionEncoder Implied(final boolean value)
    {
        CodecUtil.uint8PutChoice(buffer, offset, 0, value);
        return this;
    }

    public QuoteConditionEncoder ExchangeBest(final boolean value)
    {
        CodecUtil.uint8PutChoice(buffer, offset, 1, value);
        return this;
    }
}
