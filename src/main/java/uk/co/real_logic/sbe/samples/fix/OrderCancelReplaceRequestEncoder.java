/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.samples.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

public class OrderCancelReplaceRequestEncoder
{
    public static final int BLOCK_LENGTH = 204;
    public static final int TEMPLATE_ID = 71;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final OrderCancelReplaceRequestEncoder parentMessage = this;
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
        return "G";
    }

    public int offset()
    {
        return offset;
    }

    public OrderCancelReplaceRequestEncoder wrap(final MutableDirectBuffer buffer, final int offset)
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
    public OrderCancelReplaceRequestEncoder putAccount(final byte[] src, final int srcOffset)
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
    public OrderCancelReplaceRequestEncoder putClOrdID(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 12, src, srcOffset, length);
        return this;
    }

    public static long orderIDNullValue()
    {
        return -9223372036854775808L;
    }

    public static long orderIDMinValue()
    {
        return -9223372036854775807L;
    }

    public static long orderIDMaxValue()
    {
        return 9223372036854775807L;
    }
    public OrderCancelReplaceRequestEncoder orderID(final long value)
    {
        CodecUtil.int64Put(buffer, offset + 32, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }
    public OrderCancelReplaceRequestEncoder handInst(final HandInst value)
    {
        CodecUtil.charPut(buffer, offset + 40, value.value());
        return this;
    }

    private final IntQty32Encoder orderQty = new IntQty32Encoder();

    public IntQty32Encoder orderQty()
    {
        orderQty.wrap(buffer, offset + 41, actingVersion);
        return orderQty;
    }
    public OrderCancelReplaceRequestEncoder custOrderHandlingInst(final CustOrderHandlingInst value)
    {
        CodecUtil.charPut(buffer, offset + 45, value.value());
        return this;
    }
    public OrderCancelReplaceRequestEncoder ordType(final OrdType value)
    {
        CodecUtil.charPut(buffer, offset + 46, value.value());
        return this;
    }

    public static byte origClOrdIDNullValue()
    {
        return (byte)0;
    }

    public static byte origClOrdIDMinValue()
    {
        return (byte)32;
    }

    public static byte origClOrdIDMaxValue()
    {
        return (byte)126;
    }

    public static int origClOrdIDLength()
    {
        return 20;
    }

    public void origClOrdID(final int index, final byte value)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 47 + (index * 1), value);
    }

    public static String origClOrdIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putOrigClOrdID(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 47, src, srcOffset, length);
        return this;
    }

    private final OptionalPriceEncoder price = new OptionalPriceEncoder();

    public OptionalPriceEncoder price()
    {
        price.wrap(buffer, offset + 67, actingVersion);
        return price;
    }
    public OrderCancelReplaceRequestEncoder side(final Side value)
    {
        CodecUtil.charPut(buffer, offset + 76, value.value());
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

        CodecUtil.charPut(buffer, this.offset + 77 + (index * 1), value);
    }

    public static String symbolCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putSymbol(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 77, src, srcOffset, length);
        return this;
    }

    public static byte testNullValue()
    {
        return (byte)0;
    }

    public static byte testMinValue()
    {
        return (byte)32;
    }

    public static byte testMaxValue()
    {
        return (byte)126;
    }

    public static int testLength()
    {
        return 18;
    }

    public void test(final int index, final byte value)
    {
        if (index < 0 || index >= 18)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 83 + (index * 1), value);
    }

    public static String testCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putTest(final byte[] src, final int srcOffset)
    {
        final int length = 18;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 83, src, srcOffset, length);
        return this;
    }
    public OrderCancelReplaceRequestEncoder timeInForce(final TimeInForce value)
    {
        CodecUtil.charPut(buffer, offset + 101, value.value());
        return this;
    }
    public OrderCancelReplaceRequestEncoder manualOrderIndicator(final BooleanType value)
    {
        CodecUtil.uint8Put(buffer, offset + 102, value.value());
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
    public OrderCancelReplaceRequestEncoder transactTime(final long value)
    {
        CodecUtil.uint64Put(buffer, offset + 103, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }
    public OrderCancelReplaceRequestEncoder noAllocs(final NoAllocs value)
    {
        CodecUtil.charPut(buffer, offset + 111, value.value());
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

        CodecUtil.charPut(buffer, this.offset + 112 + (index * 1), value);
    }

    public static String allocAccountCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putAllocAccount(final byte[] src, final int srcOffset)
    {
        final int length = 10;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 112, src, srcOffset, length);
        return this;
    }

    private final OptionalPriceEncoder stopPx = new OptionalPriceEncoder();

    public OptionalPriceEncoder stopPx()
    {
        stopPx.wrap(buffer, offset + 122, actingVersion);
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

        CodecUtil.charPut(buffer, this.offset + 131 + (index * 1), value);
    }

    public static String securityDescCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putSecurityDesc(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 131, src, srcOffset, length);
        return this;
    }

    private final IntQty32Encoder minQty = new IntQty32Encoder();

    public IntQty32Encoder minQty()
    {
        minQty.wrap(buffer, offset + 151, actingVersion);
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

        CodecUtil.charPut(buffer, this.offset + 155 + (index * 1), value);
    }

    public static String securityTypeCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putSecurityType(final byte[] src, final int srcOffset)
    {
        final int length = 3;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 155, src, srcOffset, length);
        return this;
    }
    public OrderCancelReplaceRequestEncoder customerOrFirm(final CustomerOrFirm value)
    {
        CodecUtil.uint8Put(buffer, offset + 158, value.value());
        return this;
    }

    private final IntQty32Encoder maxShow = new IntQty32Encoder();

    public IntQty32Encoder maxShow()
    {
        maxShow.wrap(buffer, offset + 159, actingVersion);
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
    public OrderCancelReplaceRequestEncoder expireDate(final int value)
    {
        CodecUtil.uint16Put(buffer, offset + 163, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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

        CodecUtil.charPut(buffer, this.offset + 165 + (index * 1), value);
    }

    public static String selfMatchPreventionIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putSelfMatchPreventionID(final byte[] src, final int srcOffset)
    {
        final int length = 12;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 165, src, srcOffset, length);
        return this;
    }
    public OrderCancelReplaceRequestEncoder ctiCode(final CtiCode value)
    {
        CodecUtil.charPut(buffer, offset + 177, value.value());
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

        CodecUtil.charPut(buffer, this.offset + 178 + (index * 1), value);
    }

    public static String giveUpFirmCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putGiveUpFirm(final byte[] src, final int srcOffset)
    {
        final int length = 3;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 178, src, srcOffset, length);
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

        CodecUtil.charPut(buffer, this.offset + 181 + (index * 1), value);
    }

    public static String cmtaGiveupCDCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putCmtaGiveupCD(final byte[] src, final int srcOffset)
    {
        final int length = 2;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 181, src, srcOffset, length);
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

        CodecUtil.charPut(buffer, this.offset + 183 + (index * 1), value);
    }

    public static String correlationClOrdIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public OrderCancelReplaceRequestEncoder putCorrelationClOrdID(final byte[] src, final int srcOffset)
    {
        final int length = 20;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 183, src, srcOffset, length);
        return this;
    }
    public OrderCancelReplaceRequestEncoder oFMOverride(final OFMOverride value)
    {
        CodecUtil.charPut(buffer, offset + 203, value.value());
        return this;
    }
}
