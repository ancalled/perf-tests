/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

@GroupOrder({MassQuoteEncoder.QuoteSetsEncoder.class})
public class MassQuoteEncoder
{
    public static final int BLOCK_LENGTH = 62;
    public static final int TEMPLATE_ID = 105;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final MassQuoteEncoder parentMessage = this;
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
        return "i";
    }

    public int offset()
    {
        return offset;
    }

    public MassQuoteEncoder wrap(final MutableDirectBuffer buffer, final int offset)
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

    public void quoteReqID(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 0 + (index * 1), value);
    }

    public static String quoteReqIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public MassQuoteEncoder putQuoteReqID(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 0, src, srcOffset, length);
        return this;
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

    public void quoteID(final int index, final byte value)
    {
        if (index < 0 || index >= 10)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 23 + (index * 1), value);
    }

    public static String quoteIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public MassQuoteEncoder putQuoteID(final byte[] src, final int srcOffset)
    {
        final int length = 10;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 23, src, srcOffset, length);
        return this;
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

    public void mMAccount(final int index, final byte value)
    {
        if (index < 0 || index >= 12)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 33 + (index * 1), value);
    }

    public static String mMAccountCharacterEncoding()
    {
        return "UTF-8";
    }
    public MassQuoteEncoder putMMAccount(final byte[] src, final int srcOffset)
    {
        final int length = 12;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 33, src, srcOffset, length);
        return this;
    }
    public MassQuoteEncoder manualOrderIndicator(final BooleanType value)
    {
        CodecUtil.uint8Put(buffer, offset + 45, value.value());
        return this;
    }
    public MassQuoteEncoder custOrderHandlingInst(final CustOrderHandlingInst value)
    {
        CodecUtil.charPut(buffer, offset + 46, value.value());
        return this;
    }
    public MassQuoteEncoder customerOrFirm(final CustomerOrFirm value)
    {
        CodecUtil.uint8Put(buffer, offset + 47, value.value());
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

        CodecUtil.charPut(buffer, this.offset + 48 + (index * 1), value);
    }

    public static String selfMatchPreventionIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public MassQuoteEncoder putSelfMatchPreventionID(final byte[] src, final int srcOffset)
    {
        final int length = 12;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 48, src, srcOffset, length);
        return this;
    }
    public MassQuoteEncoder ctiCode(final CtiCode value)
    {
        CodecUtil.charPut(buffer, offset + 60, value.value());
        return this;
    }
    public MassQuoteEncoder mMProtectionReset(final MMProtectionReset value)
    {
        CodecUtil.charPut(buffer, offset + 61, value.value());
        return this;
    }

    private final QuoteSetsEncoder quoteSets = new QuoteSetsEncoder();

    public static long quoteSetsId()
    {
        return 296;
    }

    public QuoteSetsEncoder quoteSetsCount(final int count)
    {
        quoteSets.wrap(parentMessage, buffer, count);
        return quoteSets;
    }
@GroupOrder({QuoteSetsEncoder.QuoteEntriesEncoder.class})

    public static class QuoteSetsEncoder
    {
        private static final int HEADER_SIZE = 3;
        private final GroupSizeEncodingEncoder dimensions = new GroupSizeEncodingEncoder();
        private MassQuoteEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int blockLength;
        private int actingVersion;
        private int count;
        private int index;
        private int offset;

        public void wrap(final MassQuoteEncoder parentMessage, final MutableDirectBuffer buffer, final int count)
        {
            this.parentMessage = parentMessage;
            this.buffer = buffer;
            actingVersion = SCHEMA_VERSION;
            dimensions.wrap(buffer, parentMessage.limit(), actingVersion);
            dimensions.blockLength((int)24);
            dimensions.numInGroup((short)count);
            index = -1;
            this.count = count;
            blockLength = 24;
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

        public QuoteSetsEncoder next()
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

        public void quoteSetID(final int index, final byte value)
        {
            if (index < 0 || index >= 3)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            CodecUtil.charPut(buffer, this.offset + 0 + (index * 1), value);
        }

        public static String quoteSetIDCharacterEncoding()
        {
            return "UTF-8";
        }
        public QuoteSetsEncoder putQuoteSetID(final byte[] src, final int srcOffset)
        {
            final int length = 3;
            if (srcOffset < 0 || srcOffset > (src.length - length))
            {
                throw new IndexOutOfBoundsException(    "srcOffset out of range for copy: offset=" + srcOffset);
            }

            CodecUtil.charsPut(buffer, this.offset + 0, src, srcOffset, length);
            return this;
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

        public void underlyingSecurityDesc(final int index, final byte value)
        {
            if (index < 0 || index >= 20)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            CodecUtil.charPut(buffer, this.offset + 3 + (index * 1), value);
        }

        public static String underlyingSecurityDescCharacterEncoding()
        {
            return "UTF-8";
        }
        public QuoteSetsEncoder putUnderlyingSecurityDesc(final byte[] src, final int srcOffset)
        {
            final int length = 20;
            if (srcOffset < 0 || srcOffset > (src.length - length))
            {
                throw new IndexOutOfBoundsException(    "srcOffset out of range for copy: offset=" + srcOffset);
            }

            CodecUtil.charsPut(buffer, this.offset + 3, src, srcOffset, length);
            return this;
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
        public QuoteSetsEncoder totQuoteEntries(final short value)
        {
            CodecUtil.uint8Put(buffer, offset + 23, value);
            return this;
        }

        private final QuoteEntriesEncoder quoteEntries = new QuoteEntriesEncoder();

        public static long quoteEntriesId()
        {
            return 295;
        }

        public QuoteEntriesEncoder quoteEntriesCount(final int count)
        {
            quoteEntries.wrap(parentMessage, buffer, count);
            return quoteEntries;
        }

        public static class QuoteEntriesEncoder
        {
            private static final int HEADER_SIZE = 3;
            private final GroupSizeEncodingEncoder dimensions = new GroupSizeEncodingEncoder();
            private MassQuoteEncoder parentMessage;
            private MutableDirectBuffer buffer;
            private int blockLength;
            private int actingVersion;
            private int count;
            private int index;
            private int offset;

            public void wrap(final MassQuoteEncoder parentMessage, final MutableDirectBuffer buffer, final int count)
            {
                this.parentMessage = parentMessage;
                this.buffer = buffer;
                actingVersion = SCHEMA_VERSION;
                dimensions.wrap(buffer, parentMessage.limit(), actingVersion);
                dimensions.blockLength((int)90);
                dimensions.numInGroup((short)count);
                index = -1;
                this.count = count;
                blockLength = 90;
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

            public QuoteEntriesEncoder next()
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

            public void quoteEntryID(final int index, final byte value)
            {
                if (index < 0 || index >= 10)
                {
                    throw new IndexOutOfBoundsException("index out of range: index=" + index);
                }

                CodecUtil.charPut(buffer, this.offset + 0 + (index * 1), value);
            }

            public static String quoteEntryIDCharacterEncoding()
            {
                return "UTF-8";
            }
            public QuoteEntriesEncoder putQuoteEntryID(final byte[] src, final int srcOffset)
            {
                final int length = 10;
                if (srcOffset < 0 || srcOffset > (src.length - length))
                {
                    throw new IndexOutOfBoundsException(        "srcOffset out of range for copy: offset=" + srcOffset);
                }

                CodecUtil.charsPut(buffer, this.offset + 0, src, srcOffset, length);
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

                CodecUtil.charPut(buffer, this.offset + 10 + (index * 1), value);
            }

            public static String symbolCharacterEncoding()
            {
                return "UTF-8";
            }
            public QuoteEntriesEncoder putSymbol(final byte[] src, final int srcOffset)
            {
                final int length = 6;
                if (srcOffset < 0 || srcOffset > (src.length - length))
                {
                    throw new IndexOutOfBoundsException(        "srcOffset out of range for copy: offset=" + srcOffset);
                }

                CodecUtil.charsPut(buffer, this.offset + 10, src, srcOffset, length);
                return this;
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

                CodecUtil.charPut(buffer, this.offset + 16 + (index * 1), value);
            }

            public static String securityDescCharacterEncoding()
            {
                return "UTF-8";
            }
            public QuoteEntriesEncoder putSecurityDesc(final byte[] src, final int srcOffset)
            {
                final int length = 20;
                if (srcOffset < 0 || srcOffset > (src.length - length))
                {
                    throw new IndexOutOfBoundsException(        "srcOffset out of range for copy: offset=" + srcOffset);
                }

                CodecUtil.charsPut(buffer, this.offset + 16, src, srcOffset, length);
                return this;
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

                CodecUtil.charPut(buffer, this.offset + 36 + (index * 1), value);
            }

            public static String securityTypeCharacterEncoding()
            {
                return "UTF-8";
            }
            public QuoteEntriesEncoder putSecurityType(final byte[] src, final int srcOffset)
            {
                final int length = 3;
                if (srcOffset < 0 || srcOffset > (src.length - length))
                {
                    throw new IndexOutOfBoundsException(        "srcOffset out of range for copy: offset=" + srcOffset);
                }

                CodecUtil.charsPut(buffer, this.offset + 36, src, srcOffset, length);
                return this;
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
            public QuoteEntriesEncoder securityID(final long value)
            {
                CodecUtil.int64Put(buffer, offset + 39, value, java.nio.ByteOrder.LITTLE_ENDIAN);
                return this;
            }
            public QuoteEntriesEncoder securityIDSource(final SecurityIDSource value)
            {
                CodecUtil.charPut(buffer, offset + 47, value.value());
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
            public QuoteEntriesEncoder transactTime(final long value)
            {
                CodecUtil.uint64Put(buffer, offset + 48, value, java.nio.ByteOrder.LITTLE_ENDIAN);
                return this;
            }

            private final OptionalPriceEncoder bidPx = new OptionalPriceEncoder();

            public OptionalPriceEncoder bidPx()
            {
                bidPx.wrap(buffer, offset + 56, actingVersion);
                return bidPx;
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
            public QuoteEntriesEncoder bidSize(final long value)
            {
                CodecUtil.int64Put(buffer, offset + 65, value, java.nio.ByteOrder.LITTLE_ENDIAN);
                return this;
            }

            private final OptionalPriceEncoder offerPx = new OptionalPriceEncoder();

            public OptionalPriceEncoder offerPx()
            {
                offerPx.wrap(buffer, offset + 73, actingVersion);
                return offerPx;
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
            public QuoteEntriesEncoder offerSize(final long value)
            {
                CodecUtil.int64Put(buffer, offset + 82, value, java.nio.ByteOrder.LITTLE_ENDIAN);
                return this;
            }
        }
    }
}
