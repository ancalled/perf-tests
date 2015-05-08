/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.DirectBuffer;

public class OrderCancelReplaceRequestDecoder
{
    public static final int BLOCK_LENGTH = 204;
    public static final int TEMPLATE_ID = 71;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final OrderCancelReplaceRequestDecoder parentMessage = this;
    private DirectBuffer buffer;
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

    public OrderCancelReplaceRequestDecoder wrap(
        final DirectBuffer buffer, final int offset, final int actingBlockLength, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

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

    public static int AccountId()
    {
        return 1;
    }

    public static String AccountMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte account(final int index)
    {
        if (index < 0 || index >= 12)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 0 + (index * 1));
    }


    public static String accountCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getAccount(final byte[] dst, final int dstOffset)
    {
        final int length = 12;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 0, dst, dstOffset, length);
        return length;
    }


    public static int ClOrdIDId()
    {
        return 11;
    }

    public static String ClOrdIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte clOrdID(final int index)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 12 + (index * 1));
    }


    public static String clOrdIDCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getClOrdID(final byte[] dst, final int dstOffset)
    {
        final int length = 20;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 12, dst, dstOffset, length);
        return length;
    }


    public static int OrderIDId()
    {
        return 37;
    }

    public static String OrderIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "int";
        }

        return "";
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

    public long orderID()
    {
        return CodecUtil.int64Get(buffer, offset + 32, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int HandInstId()
    {
        return 21;
    }

    public static String HandInstMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "char";
        }

        return "";
    }

    public HandInst handInst()
    {
        return HandInst.get(CodecUtil.charGet(buffer, offset + 40));
    }


    public static int OrderQtyId()
    {
        return 38;
    }

    public static String OrderQtyMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "Qty";
        }

        return "";
    }

    private final IntQty32Decoder orderQty = new IntQty32Decoder();

    public IntQty32Decoder orderQty()
    {
        orderQty.wrap(buffer, offset + 41, actingVersion);
        return orderQty;
    }

    public static int CustOrderHandlingInstId()
    {
        return 1031;
    }

    public static String CustOrderHandlingInstMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "char";
        }

        return "";
    }

    public CustOrderHandlingInst custOrderHandlingInst()
    {
        return CustOrderHandlingInst.get(CodecUtil.charGet(buffer, offset + 45));
    }


    public static int OrdTypeId()
    {
        return 40;
    }

    public static String OrdTypeMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "char";
        }

        return "";
    }

    public OrdType ordType()
    {
        return OrdType.get(CodecUtil.charGet(buffer, offset + 46));
    }


    public static int OrigClOrdIDId()
    {
        return 41;
    }

    public static String OrigClOrdIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte origClOrdID(final int index)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 47 + (index * 1));
    }


    public static String origClOrdIDCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getOrigClOrdID(final byte[] dst, final int dstOffset)
    {
        final int length = 20;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 47, dst, dstOffset, length);
        return length;
    }


    public static int PriceId()
    {
        return 44;
    }

    public static String PriceMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "Price";
        }

        return "";
    }

    private final OptionalPriceDecoder price = new OptionalPriceDecoder();

    public OptionalPriceDecoder price()
    {
        price.wrap(buffer, offset + 67, actingVersion);
        return price;
    }

    public static int SideId()
    {
        return 54;
    }

    public static String SideMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "char";
        }

        return "";
    }

    public Side side()
    {
        return Side.get(CodecUtil.charGet(buffer, offset + 76));
    }


    public static int SymbolId()
    {
        return 55;
    }

    public static String SymbolMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte symbol(final int index)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 77 + (index * 1));
    }


    public static String symbolCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getSymbol(final byte[] dst, final int dstOffset)
    {
        final int length = 6;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 77, dst, dstOffset, length);
        return length;
    }


    public static int TestId()
    {
        return 58;
    }

    public static String TestMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte test(final int index)
    {
        if (index < 0 || index >= 18)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 83 + (index * 1));
    }


    public static String testCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getTest(final byte[] dst, final int dstOffset)
    {
        final int length = 18;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 83, dst, dstOffset, length);
        return length;
    }


    public static int TimeInForceId()
    {
        return 59;
    }

    public static String TimeInForceMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "char";
        }

        return "";
    }

    public TimeInForce timeInForce()
    {
        return TimeInForce.get(CodecUtil.charGet(buffer, offset + 101));
    }


    public static int ManualOrderIndicatorId()
    {
        return 1028;
    }

    public static String ManualOrderIndicatorMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public BooleanType manualOrderIndicator()
    {
        return BooleanType.get(CodecUtil.uint8Get(buffer, offset + 102));
    }


    public static int TransactTimeId()
    {
        return 60;
    }

    public static String TransactTimeMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "UTCTimestamp";
        }

        return "";
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

    public long transactTime()
    {
        return CodecUtil.uint64Get(buffer, offset + 103, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int NoAllocsId()
    {
        return 78;
    }

    public static String NoAllocsMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public NoAllocs noAllocs()
    {
        return NoAllocs.get(CodecUtil.charGet(buffer, offset + 111));
    }


    public static int AllocAccountId()
    {
        return 79;
    }

    public static String AllocAccountMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte allocAccount(final int index)
    {
        if (index < 0 || index >= 10)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 112 + (index * 1));
    }


    public static String allocAccountCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getAllocAccount(final byte[] dst, final int dstOffset)
    {
        final int length = 10;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 112, dst, dstOffset, length);
        return length;
    }


    public static int StopPxId()
    {
        return 99;
    }

    public static String StopPxMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "Price";
        }

        return "";
    }

    private final OptionalPriceDecoder stopPx = new OptionalPriceDecoder();

    public OptionalPriceDecoder stopPx()
    {
        stopPx.wrap(buffer, offset + 122, actingVersion);
        return stopPx;
    }

    public static int SecurityDescId()
    {
        return 107;
    }

    public static String SecurityDescMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte securityDesc(final int index)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 131 + (index * 1));
    }


    public static String securityDescCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getSecurityDesc(final byte[] dst, final int dstOffset)
    {
        final int length = 20;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 131, dst, dstOffset, length);
        return length;
    }


    public static int MinQtyId()
    {
        return 110;
    }

    public static String MinQtyMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "Qty";
        }

        return "";
    }

    private final IntQty32Decoder minQty = new IntQty32Decoder();

    public IntQty32Decoder minQty()
    {
        minQty.wrap(buffer, offset + 151, actingVersion);
        return minQty;
    }

    public static int SecurityTypeId()
    {
        return 167;
    }

    public static String SecurityTypeMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte securityType(final int index)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 155 + (index * 1));
    }


    public static String securityTypeCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getSecurityType(final byte[] dst, final int dstOffset)
    {
        final int length = 3;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 155, dst, dstOffset, length);
        return length;
    }


    public static int CustomerOrFirmId()
    {
        return 204;
    }

    public static String CustomerOrFirmMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public CustomerOrFirm customerOrFirm()
    {
        return CustomerOrFirm.get(CodecUtil.uint8Get(buffer, offset + 158));
    }


    public static int MaxShowId()
    {
        return 210;
    }

    public static String MaxShowMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "Qty";
        }

        return "";
    }

    private final IntQty32Decoder maxShow = new IntQty32Decoder();

    public IntQty32Decoder maxShow()
    {
        maxShow.wrap(buffer, offset + 159, actingVersion);
        return maxShow;
    }

    public static int ExpireDateId()
    {
        return 432;
    }

    public static String ExpireDateMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public int expireDate()
    {
        return CodecUtil.uint16Get(buffer, offset + 163, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int SelfMatchPreventionIDId()
    {
        return 7928;
    }

    public static String SelfMatchPreventionIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte selfMatchPreventionID(final int index)
    {
        if (index < 0 || index >= 12)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 165 + (index * 1));
    }


    public static String selfMatchPreventionIDCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getSelfMatchPreventionID(final byte[] dst, final int dstOffset)
    {
        final int length = 12;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 165, dst, dstOffset, length);
        return length;
    }


    public static int CtiCodeId()
    {
        return 9702;
    }

    public static String CtiCodeMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public CtiCode ctiCode()
    {
        return CtiCode.get(CodecUtil.charGet(buffer, offset + 177));
    }


    public static int GiveUpFirmId()
    {
        return 9707;
    }

    public static String GiveUpFirmMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte giveUpFirm(final int index)
    {
        if (index < 0 || index >= 3)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 178 + (index * 1));
    }


    public static String giveUpFirmCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getGiveUpFirm(final byte[] dst, final int dstOffset)
    {
        final int length = 3;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 178, dst, dstOffset, length);
        return length;
    }


    public static int CmtaGiveupCDId()
    {
        return 9708;
    }

    public static String CmtaGiveupCDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte cmtaGiveupCD(final int index)
    {
        if (index < 0 || index >= 2)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 181 + (index * 1));
    }


    public static String cmtaGiveupCDCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getCmtaGiveupCD(final byte[] dst, final int dstOffset)
    {
        final int length = 2;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 181, dst, dstOffset, length);
        return length;
    }


    public static int CorrelationClOrdIDId()
    {
        return 9717;
    }

    public static String CorrelationClOrdIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
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

    public byte correlationClOrdID(final int index)
    {
        if (index < 0 || index >= 20)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 183 + (index * 1));
    }


    public static String correlationClOrdIDCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getCorrelationClOrdID(final byte[] dst, final int dstOffset)
    {
        final int length = 20;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 183, dst, dstOffset, length);
        return length;
    }


    public static int OFMOverrideId()
    {
        return 9768;
    }

    public static String OFMOverrideMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public OFMOverride oFMOverride()
    {
        return OFMOverride.get(CodecUtil.charGet(buffer, offset + 203));
    }

}
