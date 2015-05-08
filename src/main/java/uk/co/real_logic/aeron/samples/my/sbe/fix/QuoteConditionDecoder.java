/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.DirectBuffer;

public class QuoteConditionDecoder
{
    private DirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public QuoteConditionDecoder wrap(final DirectBuffer buffer, final int offset, final int actingVersion)
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

    public boolean Implied()
    {
        return CodecUtil.uint8GetChoice(buffer, offset, 0);
    }


    public boolean ExchangeBest()
    {
        return CodecUtil.uint8GetChoice(buffer, offset, 1);
    }

}
