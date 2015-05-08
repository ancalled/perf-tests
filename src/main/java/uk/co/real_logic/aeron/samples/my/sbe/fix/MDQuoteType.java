/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

public enum MDQuoteType
{
    TRADABLE((short)1),
    NULL_VAL((short)255);

    private final short value;

    MDQuoteType(final short value)
    {
        this.value = value;
    }

    public short value()
    {
        return value;
    }

    public static MDQuoteType get(final short value)
    {
        switch (value)
        {
            case 1: return TRADABLE;
        }

        if ((short)255 == value)
        {
            return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
