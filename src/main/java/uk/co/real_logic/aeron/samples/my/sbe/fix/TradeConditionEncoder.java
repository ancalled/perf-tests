/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

public class TradeConditionEncoder
{
    private MutableDirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public TradeConditionEncoder wrap(final MutableDirectBuffer buffer, final int offset, final int actingVersion)
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

    public TradeConditionEncoder clear()
    {
        CodecUtil.uint8Put(buffer, offset, (short)0);
        return this;
    }

    public TradeConditionEncoder OpeningTrade(final boolean value)
    {
        CodecUtil.uint8PutChoice(buffer, offset, 0, value);
        return this;
    }

    public TradeConditionEncoder CmeGlobexPrice(final boolean value)
    {
        CodecUtil.uint8PutChoice(buffer, offset, 1, value);
        return this;
    }
}
