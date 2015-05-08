/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

public enum BooleanType
{
    FIX_FALSE((short)0),
    FIX_TRUE((short)1),
    NULL_VAL((short)255);

    private final short value;

    BooleanType(final short value)
    {
        this.value = value;
    }

    public short value()
    {
        return value;
    }

    public static BooleanType get(final short value)
    {
        switch (value)
        {
            case 0: return FIX_FALSE;
            case 1: return FIX_TRUE;
        }

        if ((short)255 == value)
        {
            return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
