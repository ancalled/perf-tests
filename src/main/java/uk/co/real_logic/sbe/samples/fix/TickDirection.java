/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.samples.fix;

public enum TickDirection
{
    PLUS_TICK((short)0),
    MINUS_TICK((short)1),
    NULL_VAL((short)255);

    private final short value;

    TickDirection(final short value)
    {
        this.value = value;
    }

    public short value()
    {
        return value;
    }

    public static TickDirection get(final short value)
    {
        switch (value)
        {
            case 0: return PLUS_TICK;
            case 1: return MINUS_TICK;
        }

        if ((short)255 == value)
        {
            return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
