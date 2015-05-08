/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.samples.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

public class NewOrderEncoder
{
    public static final int BLOCK_LENGTH = 156;
    public static final int TEMPLATE_ID = 68;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final NewOrderEncoder parentMessage = this;
    private MutableDirectBuffer buffer;
    protected int offset;
    protected int limit;
    protected int actingBlockLength;
    protected int actingVersion;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "D";
    }

    public int offset()
    {
        return offset;
    }

    public NewOrderEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        this.buffer = buffer;
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);
        return this;
    }

    public int size()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        buffer.checkLimit(limit);
        this.limit = limit;
    }

    public static byte accountNullValue()
    {
        return (byte)0;
    }

    public static byte accountMinValue()
    {
        return (byte)32;
    }

    public static byte accountMaxValue()
    {
        return (byte)126;
    }

    public static int accountLength()
    {
        return 12;
    }

    public void account(final int index, final byte value)
    {
        if (index < 0 || index >= 12)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 0 + (index * 1), value);
    }

    public static String accountCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putAccount(final byte[] src, final int srcOffset)
    {
        final int length = 12;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 0, src, srcOffset, length);
        return this;
    }

    public static byte clOrdIDNullValue()
    {
        return (byte)0;
    }

    public static byte clOrdIDMinValue()
    {
        return (byte)32;
    }

    public static byte clOrdIDMaxValue()
    {
        return (byte)126;
    }

    public static int clOrdIDLength()
    {
        return 20;
    }

    public void clOrdID(final int index, final byte value)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 12 + (index * 1), value);
    }

    public static String clOrdIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putClOrdID(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 12, src, srcOffset, length);
        return this;
    }
    public NewOrderEncoder handInst(final HandInst value)
    {
        CodecUtil.charPut(buffer, offset + 32, value.value());
        return this;
    }
    public NewOrderEncoder custOrderHandlingInst(final CustOrderHandlingInst value)
    {
        CodecUtil.charPut(buffer, offset + 33, value.value());
        return this;
    }

    private final IntQty32Encoder orderQty = new IntQty32Encoder();

    public IntQty32Encoder orderQty()
    {
        orderQty.wrap(buffer, offset + 34, actingVersion);
        return orderQty;
    }
    public NewOrderEncoder ordType(final OrdType value)
    {
        CodecUtil.charPut(buffer, offset + 38, value.value());
        return this;
    }

    private final OptionalPriceEncoder price = new OptionalPriceEncoder();

    public OptionalPriceEncoder price()
    {
        price.wrap(buffer, offset + 39, actingVersion);
        return price;
    }
    public NewOrderEncoder side(final Side value)
    {
        CodecUtil.charPut(buffer, offset + 48, value.value());
        return this;
    }

    public static byte symbolNullValue()
    {
        return (byte)0;
    }

    public static byte symbolMinValue()
    {
        return (byte)32;
    }

    public static byte symbolMaxValue()
    {
        return (byte)126;
    }

    public static int symbolLength()
    {
        return 6;
    }

    public void symbol(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 49 + (index * 1), value);
    }

    public static String symbolCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putSymbol(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 49, src, srcOffset, length);
        return this;
    }
    public NewOrderEncoder timeInForce(final TimeInForce value)
    {
        CodecUtil.charPut(buffer, offset + 55, value.value());
        return this;
    }

    public static long transactTimeNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long transactTimeMinValue()
    {
        return 0x0L;
    }

    public static long transactTimeMaxValue()
    {
        return 0xfffffffffffffffeL;
    }
    public NewOrderEncoder transactTime(final long value)
    {
        CodecUtil.uint64Put(buffer, offset + 56, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }
    public NewOrderEncoder manualOrderIndicator(final BooleanType value)
    {
        CodecUtil.uint8Put(buffer, offset + 64, value.value());
        return this;
    }

    public static byte allocAccountNullValue()
    {
        return (byte)0;
    }

    public static byte allocAccountMinValue()
    {
        return (byte)32;
    }

    public static byte allocAccountMaxValue()
    {
        return (byte)126;
    }

    public static int allocAccountLength()
    {
        return 10;
    }

    public void allocAccount(final int index, final byte value)
    {
        if (index < 0 || index >= 10)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 65 + (index * 1), value);
    }

    public static String allocAccountCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putAllocAccount(final byte[] src, final int srcOffset)
    {
        final int length = 10;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 65, src, srcOffset, length);
        return this;
    }

    private final OptionalPriceEncoder stopPx = new OptionalPriceEncoder();

    public OptionalPriceEncoder stopPx()
    {
        stopPx.wrap(buffer, offset + 75, actingVersion);
        return stopPx;
    }

    public static byte securityDescNullValue()
    {
        return (byte)0;
    }

    public static byte securityDescMinValue()
    {
        return (byte)32;
    }

    public static byte securityDescMaxValue()
    {
        return (byte)126;
    }

    public static int securityDescLength()
    {
        return 20;
    }

    public void securityDesc(final int index, final byte value)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 84 + (index * 1), value);
    }

    public static String securityDescCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putSecurityDesc(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 84, src, srcOffset, length);
        return this;
    }

    private final IntQty32Encoder minQty = new IntQty32Encoder();

    public IntQty32Encoder minQty()
    {
        minQty.wrap(buffer, offset + 104, actingVersion);
        return minQty;
    }

    public static byte securityTypeNullValue()
    {
        return (byte)0;
    }

    public static byte securityTypeMinValue()
    {
        return (byte)32;
    }

    public static byte securityTypeMaxValue()
    {
        return (byte)126;
    }

    public static int securityTypeLength()
    {
        return 3;
    }

    public void securityType(final int index, final byte value)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 108 + (index * 1), value);
    }

    public static String securityTypeCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putSecurityType(final byte[] src, final int srcOffset)
    {
        final int length = 3;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 108, src, srcOffset, length);
        return this;
    }
    public NewOrderEncoder customerOrFirm(final CustomerOrFirm value)
    {
        CodecUtil.uint8Put(buffer, offset + 111, value.value());
        return this;
    }

    private final IntQty32Encoder maxShow = new IntQty32Encoder();

    public IntQty32Encoder maxShow()
    {
        maxShow.wrap(buffer, offset + 112, actingVersion);
        return maxShow;
    }

    public static int expireDateNullValue()
    {
        return 65535;
    }

    public static int expireDateMinValue()
    {
        return 0;
    }

    public static int expireDateMaxValue()
    {
        return 65534;
    }
    public NewOrderEncoder expireDate(final int value)
    {
        CodecUtil.uint16Put(buffer, offset + 116, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public static byte selfMatchPreventionIDNullValue()
    {
        return (byte)0;
    }

    public static byte selfMatchPreventionIDMinValue()
    {
        return (byte)32;
    }

    public static byte selfMatchPreventionIDMaxValue()
    {
        return (byte)126;
    }

    public static int selfMatchPreventionIDLength()
    {
        return 12;
    }

    public void selfMatchPreventionID(final int index, final byte value)
    {
        if (index < 0 || index >= 12)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 118 + (index * 1), value);
    }

    public static String selfMatchPreventionIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putSelfMatchPreventionID(final byte[] src, final int srcOffset)
    {
        final int length = 12;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 118, src, srcOffset, length);
        return this;
    }
    public NewOrderEncoder ctiCode(final CtiCode value)
    {
        CodecUtil.charPut(buffer, offset + 130, value.value());
        return this;
    }

    public static byte giveUpFirmNullValue()
    {
        return (byte)0;
    }

    public static byte giveUpFirmMinValue()
    {
        return (byte)32;
    }

    public static byte giveUpFirmMaxValue()
    {
        return (byte)126;
    }

    public static int giveUpFirmLength()
    {
        return 3;
    }

    public void giveUpFirm(final int index, final byte value)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 131 + (index * 1), value);
    }

    public static String giveUpFirmCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putGiveUpFirm(final byte[] src, final int srcOffset)
    {
        final int length = 3;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 131, src, srcOffset, length);
        return this;
    }

    public static byte cmtaGiveupCDNullValue()
    {
        return (byte)0;
    }

    public static byte cmtaGiveupCDMinValue()
    {
        return (byte)32;
    }

    public static byte cmtaGiveupCDMaxValue()
    {
        return (byte)126;
    }

    public static int cmtaGiveupCDLength()
    {
        return 2;
    }

    public void cmtaGiveupCD(final int index, final byte value)
    {
        if (index < 0 || index >= 2)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 134 + (index * 1), value);
    }

    public static String cmtaGiveupCDCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putCmtaGiveupCD(final byte[] src, final int srcOffset)
    {
        final int length = 2;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 134, src, srcOffset, length);
        return this;
    }

    public static byte correlationClOrdIDNullValue()
    {
        return (byte)0;
    }

    public static byte correlationClOrdIDMinValue()
    {
        return (byte)32;
    }

    public static byte correlationClOrdIDMaxValue()
    {
        return (byte)126;
    }

    public static int correlationClOrdIDLength()
    {
        return 20;
    }

    public void correlationClOrdID(final int index, final byte value)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 136 + (index * 1), value);
    }

    public static String correlationClOrdIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public NewOrderEncoder putCorrelationClOrdID(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 136, src, srcOffset, length);
        return this;
    }
}
