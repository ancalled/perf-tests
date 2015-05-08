/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.samples.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.DirectBuffer;

@GroupOrder({MassQuoteDecoder.QuoteSetsDecoder.class})
public class MassQuoteDecoder
{
    public static final int BLOCK_LENGTH = 62;
    public static final int TEMPLATE_ID = 105;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final MassQuoteDecoder parentMessage = this;
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
        return "i";
    }

    public int offset()
    {
        return offset;
    }

    public MassQuoteDecoder wrap(
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

    public static int QuoteReqIDId()
    {
        return 131;
    }

    public static String QuoteReqIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
    }

    public static byte quoteReqIDNullValue()
    {
        return (byte)0;
    }

    public static byte quoteReqIDMinValue()
    {
        return (byte)32;
    }

    public static byte quoteReqIDMaxValue()
    {
        return (byte)126;
    }

    public static int quoteReqIDLength()
    {
        return 23;
    }

    public byte quoteReqID(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 0 + (index * 1));
    }


    public static String quoteReqIDCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getQuoteReqID(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 0, dst, dstOffset, length);
        return length;
    }


    public static int QuoteIDId()
    {
        return 117;
    }

    public static String QuoteIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
    }

    public static byte quoteIDNullValue()
    {
        return (byte)0;
    }

    public static byte quoteIDMinValue()
    {
        return (byte)32;
    }

    public static byte quoteIDMaxValue()
    {
        return (byte)126;
    }

    public static int quoteIDLength()
    {
        return 10;
    }

    public byte quoteID(final int index)
    {
        if (index < 0 || index >= 10)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 23 + (index * 1));
    }


    public static String quoteIDCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getQuoteID(final byte[] dst, final int dstOffset)
    {
        final int length = 10;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 23, dst, dstOffset, length);
        return length;
    }


    public static int MMAccountId()
    {
        return 9771;
    }

    public static String MMAccountMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "String";
        }

        return "";
    }

    public static byte mMAccountNullValue()
    {
        return (byte)0;
    }

    public static byte mMAccountMinValue()
    {
        return (byte)32;
    }

    public static byte mMAccountMaxValue()
    {
        return (byte)126;
    }

    public static int mMAccountLength()
    {
        return 12;
    }

    public byte mMAccount(final int index)
    {
        if (index < 0 || index >= 12)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 33 + (index * 1));
    }


    public static String mMAccountCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getMMAccount(final byte[] dst, final int dstOffset)
    {
        final int length = 12;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 33, dst, dstOffset, length);
        return length;
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
        return BooleanType.get(CodecUtil.uint8Get(buffer, offset + 45));
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
        return CustOrderHandlingInst.get(CodecUtil.charGet(buffer, offset + 46));
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
        return CustomerOrFirm.get(CodecUtil.uint8Get(buffer, offset + 47));
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

        return CodecUtil.charGet(buffer, this.offset + 48 + (index * 1));
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

        CodecUtil.charsGet(buffer, this.offset + 48, dst, dstOffset, length);
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
        return CtiCode.get(CodecUtil.charGet(buffer, offset + 60));
    }


    public static int MMProtectionResetId()
    {
        return 9773;
    }

    public static String MMProtectionResetMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public MMProtectionReset mMProtectionReset()
    {
        return MMProtectionReset.get(CodecUtil.charGet(buffer, offset + 61));
    }


    private final QuoteSetsDecoder quoteSets = new QuoteSetsDecoder();

    public static long quoteSetsDecoderId()
    {
        return 296;
    }

    public QuoteSetsDecoder quoteSets()
    {
        quoteSets.wrap(parentMessage, buffer, actingVersion);
        return quoteSets;
    }
@GroupOrder({QuoteSetsDecoder.QuoteEntriesDecoder.class})

    public static class QuoteSetsDecoder
    implements Iterable<QuoteSetsDecoder>, java.util.Iterator<QuoteSetsDecoder>
    {
        private static final int HEADER_SIZE = 3;
        private final GroupSizeEncodingDecoder dimensions = new GroupSizeEncodingDecoder();
        private MassQuoteDecoder parentMessage;
        private DirectBuffer buffer;
        private int blockLength;
        private int actingVersion;
        private int count;
        private int index;
        private int offset;

        public void wrap(
            final MassQuoteDecoder parentMessage, final DirectBuffer buffer, final int actingVersion)
        {
            this.parentMessage = parentMessage;
            this.buffer = buffer;
            dimensions.wrap(buffer, parentMessage.limit(), actingVersion);
            blockLength = dimensions.blockLength();
            count = dimensions.numInGroup();
            this.actingVersion = actingVersion;
            index = -1;
            parentMessage.limit(parentMessage.limit() + HEADER_SIZE);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 24;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        @Override
        public java.util.Iterator<QuoteSetsDecoder> iterator()
        {
            return this;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext()
        {
            return (index + 1) < count;
        }

        @Override
        public QuoteSetsDecoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
            ++index;

            return this;
        }

        public static int QuoteSetIDId()
        {
            return 302;
        }

        public static String QuoteSetIDMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "String";
            }

            return "";
        }

        public static byte quoteSetIDNullValue()
        {
            return (byte)0;
        }

        public static byte quoteSetIDMinValue()
        {
            return (byte)32;
        }

        public static byte quoteSetIDMaxValue()
        {
            return (byte)126;
        }

        public static int quoteSetIDLength()
        {
            return 3;
        }

        public byte quoteSetID(final int index)
        {
            if (index < 0 || index >= 3)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            return CodecUtil.charGet(buffer, this.offset + 0 + (index * 1));
        }


        public static String quoteSetIDCharacterEncoding()
        {
            return "UTF-8";
        }

        public int getQuoteSetID(final byte[] dst, final int dstOffset)
        {
            final int length = 3;
            if (dstOffset < 0 || dstOffset > (dst.length - length))
            {
                throw new IndexOutOfBoundsException(    "dstOffset out of range for copy: offset=" + dstOffset);
            }

            CodecUtil.charsGet(buffer, this.offset + 0, dst, dstOffset, length);
            return length;
        }


        public static int UnderlyingSecurityDescId()
        {
            return 307;
        }

        public static String UnderlyingSecurityDescMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "String";
            }

            return "";
        }

        public static byte underlyingSecurityDescNullValue()
        {
            return (byte)0;
        }

        public static byte underlyingSecurityDescMinValue()
        {
            return (byte)32;
        }

        public static byte underlyingSecurityDescMaxValue()
        {
            return (byte)126;
        }

        public static int underlyingSecurityDescLength()
        {
            return 20;
        }

        public byte underlyingSecurityDesc(final int index)
        {
            if (index < 0 || index >= 20)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            return CodecUtil.charGet(buffer, this.offset + 3 + (index * 1));
        }


        public static String underlyingSecurityDescCharacterEncoding()
        {
            return "UTF-8";
        }

        public int getUnderlyingSecurityDesc(final byte[] dst, final int dstOffset)
        {
            final int length = 20;
            if (dstOffset < 0 || dstOffset > (dst.length - length))
            {
                throw new IndexOutOfBoundsException(    "dstOffset out of range for copy: offset=" + dstOffset);
            }

            CodecUtil.charsGet(buffer, this.offset + 3, dst, dstOffset, length);
            return length;
        }


        public static int TotQuoteEntriesId()
        {
            return 304;
        }

        public static String TotQuoteEntriesMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "int";
            }

            return "";
        }

        public static short totQuoteEntriesNullValue()
        {
            return (short)255;
        }

        public static short totQuoteEntriesMinValue()
        {
            return (short)0;
        }

        public static short totQuoteEntriesMaxValue()
        {
            return (short)254;
        }

        public short totQuoteEntries()
        {
            return CodecUtil.uint8Get(buffer, offset + 23);
        }


        private final QuoteEntriesDecoder quoteEntries = new QuoteEntriesDecoder();

        public static long quoteEntriesDecoderId()
        {
            return 295;
        }

        public QuoteEntriesDecoder quoteEntries()
        {
            quoteEntries.wrap(parentMessage, buffer, actingVersion);
            return quoteEntries;
        }

        public static class QuoteEntriesDecoder
        implements Iterable<QuoteEntriesDecoder>, java.util.Iterator<QuoteEntriesDecoder>
        {
            private static final int HEADER_SIZE = 3;
            private final GroupSizeEncodingDecoder dimensions = new GroupSizeEncodingDecoder();
            private MassQuoteDecoder parentMessage;
            private DirectBuffer buffer;
            private int blockLength;
            private int actingVersion;
            private int count;
            private int index;
            private int offset;

            public void wrap(
                final MassQuoteDecoder parentMessage, final DirectBuffer buffer, final int actingVersion)
            {
                this.parentMessage = parentMessage;
                this.buffer = buffer;
                dimensions.wrap(buffer, parentMessage.limit(), actingVersion);
                blockLength = dimensions.blockLength();
                count = dimensions.numInGroup();
                this.actingVersion = actingVersion;
                index = -1;
                parentMessage.limit(parentMessage.limit() + HEADER_SIZE);
            }

            public static int sbeHeaderSize()
            {
                return HEADER_SIZE;
            }

            public static int sbeBlockLength()
            {
                return 90;
            }

            public int actingBlockLength()
            {
                return blockLength;
            }

            public int count()
            {
                return count;
            }

            @Override
            public java.util.Iterator<QuoteEntriesDecoder> iterator()
            {
                return this;
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean hasNext()
            {
                return (index + 1) < count;
            }

            @Override
            public QuoteEntriesDecoder next()
            {
                if (index + 1 >= count)
                {
                    throw new java.util.NoSuchElementException();
                }

                offset = parentMessage.limit();
                parentMessage.limit(offset + blockLength);
                ++index;

                return this;
            }

            public static int QuoteEntryIDId()
            {
                return 299;
            }

            public static String QuoteEntryIDMetaAttribute(final MetaAttribute metaAttribute)
            {
                switch (metaAttribute)
                {
                    case EPOCH: return "unix";
                    case TIME_UNIT: return "nanosecond";
                    case SEMANTIC_TYPE: return "String";
                }

                return "";
            }

            public static byte quoteEntryIDNullValue()
            {
                return (byte)0;
            }

            public static byte quoteEntryIDMinValue()
            {
                return (byte)32;
            }

            public static byte quoteEntryIDMaxValue()
            {
                return (byte)126;
            }

            public static int quoteEntryIDLength()
            {
                return 10;
            }

            public byte quoteEntryID(final int index)
            {
                if (index < 0 || index >= 10)
                {
                    throw new IndexOutOfBoundsException("index out of range: index=" + index);
                }

                return CodecUtil.charGet(buffer, this.offset + 0 + (index * 1));
            }


            public static String quoteEntryIDCharacterEncoding()
            {
                return "UTF-8";
            }

            public int getQuoteEntryID(final byte[] dst, final int dstOffset)
            {
                final int length = 10;
                if (dstOffset < 0 || dstOffset > (dst.length - length))
                {
                    throw new IndexOutOfBoundsException(        "dstOffset out of range for copy: offset=" + dstOffset);
                }

                CodecUtil.charsGet(buffer, this.offset + 0, dst, dstOffset, length);
                return length;
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

                return CodecUtil.charGet(buffer, this.offset + 10 + (index * 1));
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
                    throw new IndexOutOfBoundsException(        "dstOffset out of range for copy: offset=" + dstOffset);
                }

                CodecUtil.charsGet(buffer, this.offset + 10, dst, dstOffset, length);
                return length;
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

                return CodecUtil.charGet(buffer, this.offset + 16 + (index * 1));
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
                    throw new IndexOutOfBoundsException(        "dstOffset out of range for copy: offset=" + dstOffset);
                }

                CodecUtil.charsGet(buffer, this.offset + 16, dst, dstOffset, length);
                return length;
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

                return CodecUtil.charGet(buffer, this.offset + 36 + (index * 1));
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
                    throw new IndexOutOfBoundsException(        "dstOffset out of range for copy: offset=" + dstOffset);
                }

                CodecUtil.charsGet(buffer, this.offset + 36, dst, dstOffset, length);
                return length;
            }


            public static int SecurityIDId()
            {
                return 48;
            }

            public static String SecurityIDMetaAttribute(final MetaAttribute metaAttribute)
            {
                switch (metaAttribute)
                {
                    case EPOCH: return "unix";
                    case TIME_UNIT: return "nanosecond";
                    case SEMANTIC_TYPE: return "int";
                }

                return "";
            }

            public static long securityIDNullValue()
            {
                return -9223372036854775808L;
            }

            public static long securityIDMinValue()
            {
                return -9223372036854775807L;
            }

            public static long securityIDMaxValue()
            {
                return 9223372036854775807L;
            }

            public long securityID()
            {
                return CodecUtil.int64Get(buffer, offset + 39, java.nio.ByteOrder.LITTLE_ENDIAN);
            }


            public static int SecurityIDSourceId()
            {
                return 22;
            }

            public static String SecurityIDSourceMetaAttribute(final MetaAttribute metaAttribute)
            {
                switch (metaAttribute)
                {
                    case EPOCH: return "unix";
                    case TIME_UNIT: return "nanosecond";
                    case SEMANTIC_TYPE: return "";
                }

                return "";
            }

            public SecurityIDSource securityIDSource()
            {
                return SecurityIDSource.get(CodecUtil.charGet(buffer, offset + 47));
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
                return CodecUtil.uint64Get(buffer, offset + 48, java.nio.ByteOrder.LITTLE_ENDIAN);
            }


            public static int BidPxId()
            {
                return 132;
            }

            public static String BidPxMetaAttribute(final MetaAttribute metaAttribute)
            {
                switch (metaAttribute)
                {
                    case EPOCH: return "unix";
                    case TIME_UNIT: return "nanosecond";
                    case SEMANTIC_TYPE: return "Price";
                }

                return "";
            }

            private final OptionalPriceDecoder bidPx = new OptionalPriceDecoder();

            public OptionalPriceDecoder bidPx()
            {
                bidPx.wrap(buffer, offset + 56, actingVersion);
                return bidPx;
            }

            public static int BidSizeId()
            {
                return 134;
            }

            public static String BidSizeMetaAttribute(final MetaAttribute metaAttribute)
            {
                switch (metaAttribute)
                {
                    case EPOCH: return "unix";
                    case TIME_UNIT: return "nanosecond";
                    case SEMANTIC_TYPE: return "int";
                }

                return "";
            }

            public static long bidSizeNullValue()
            {
                return -9223372036854775808L;
            }

            public static long bidSizeMinValue()
            {
                return -9223372036854775807L;
            }

            public static long bidSizeMaxValue()
            {
                return 9223372036854775807L;
            }

            public long bidSize()
            {
                return CodecUtil.int64Get(buffer, offset + 65, java.nio.ByteOrder.LITTLE_ENDIAN);
            }


            public static int OfferPxId()
            {
                return 133;
            }

            public static String OfferPxMetaAttribute(final MetaAttribute metaAttribute)
            {
                switch (metaAttribute)
                {
                    case EPOCH: return "unix";
                    case TIME_UNIT: return "nanosecond";
                    case SEMANTIC_TYPE: return "Price";
                }

                return "";
            }

            private final OptionalPriceDecoder offerPx = new OptionalPriceDecoder();

            public OptionalPriceDecoder offerPx()
            {
                offerPx.wrap(buffer, offset + 73, actingVersion);
                return offerPx;
            }

            public static int OfferSizeId()
            {
                return 135;
            }

            public static String OfferSizeMetaAttribute(final MetaAttribute metaAttribute)
            {
                switch (metaAttribute)
                {
                    case EPOCH: return "unix";
                    case TIME_UNIT: return "nanosecond";
                    case SEMANTIC_TYPE: return "int";
                }

                return "";
            }

            public static long offerSizeNullValue()
            {
                return -9223372036854775808L;
            }

            public static long offerSizeMinValue()
            {
                return -9223372036854775807L;
            }

            public static long offerSizeMaxValue()
            {
                return 9223372036854775807L;
            }

            public long offerSize()
            {
                return CodecUtil.int64Get(buffer, offset + 82, java.nio.ByteOrder.LITTLE_ENDIAN);
            }

        }
    }
}
