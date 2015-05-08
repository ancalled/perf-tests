/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.aeron.samples.my.sbe.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.DirectBuffer;

@GroupOrder({MarketDataIncrementalRefreshTradesDecoder.MdIncGrpDecoder.class})
public class MarketDataIncrementalRefreshTradesDecoder
{
    public static final int BLOCK_LENGTH = 11;
    public static final int TEMPLATE_ID = 2;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final MarketDataIncrementalRefreshTradesDecoder parentMessage = this;
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
        return "X";
    }

    public int offset()
    {
        return offset;
    }

    public MarketDataIncrementalRefreshTradesDecoder wrap(
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

    public static int TransactTimeId()
    {
        return 60;
    }

    public static String TransactTimeMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanossecond";
            case SEMANTIC_TYPE: return "";
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
        return CodecUtil.uint64Get(buffer, offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int EventTimeDeltaId()
    {
        return 37704;
    }

    public static String EventTimeDeltaMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static int eventTimeDeltaNullValue()
    {
        return 65535;
    }

    public static int eventTimeDeltaMinValue()
    {
        return 0;
    }

    public static int eventTimeDeltaMaxValue()
    {
        return 65534;
    }

    public int eventTimeDelta()
    {
        return CodecUtil.uint16Get(buffer, offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int MatchEventIndicatorId()
    {
        return 5799;
    }

    public static String MatchEventIndicatorMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public MatchEventIndicator matchEventIndicator()
    {
        return MatchEventIndicator.get(CodecUtil.charGet(buffer, offset + 10));
    }


    private final MdIncGrpDecoder mdIncGrp = new MdIncGrpDecoder();

    public static long mdIncGrpDecoderId()
    {
        return 268;
    }

    public MdIncGrpDecoder mdIncGrp()
    {
        mdIncGrp.wrap(parentMessage, buffer, actingVersion);
        return mdIncGrp;
    }

    public static class MdIncGrpDecoder
    implements Iterable<MdIncGrpDecoder>, java.util.Iterator<MdIncGrpDecoder>
    {
        private static final int HEADER_SIZE = 3;
        private final GroupSizeEncodingDecoder dimensions = new GroupSizeEncodingDecoder();
        private MarketDataIncrementalRefreshTradesDecoder parentMessage;
        private DirectBuffer buffer;
        private int blockLength;
        private int actingVersion;
        private int count;
        private int index;
        private int offset;

        public void wrap(
            final MarketDataIncrementalRefreshTradesDecoder parentMessage, final DirectBuffer buffer, final int actingVersion)
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
            return 34;
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
        public java.util.Iterator<MdIncGrpDecoder> iterator()
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
        public MdIncGrpDecoder next()
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

        public static int TradeIdId()
        {
            return 1003;
        }

        public static String TradeIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static long tradeIdNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long tradeIdMinValue()
        {
            return 0x0L;
        }

        public static long tradeIdMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long tradeId()
        {
            return CodecUtil.uint64Get(buffer, offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int SecurityIdId()
        {
            return 48;
        }

        public static String SecurityIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static long securityIdNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long securityIdMinValue()
        {
            return 0x0L;
        }

        public static long securityIdMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long securityId()
        {
            return CodecUtil.uint64Get(buffer, offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int MdEntryPxId()
        {
            return 270;
        }

        public static String MdEntryPxMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final Decimal64Decoder mdEntryPx = new Decimal64Decoder();

        public Decimal64Decoder mdEntryPx()
        {
            mdEntryPx.wrap(buffer, offset + 16, actingVersion);
            return mdEntryPx;
        }

        public static int MdEntrySizeId()
        {
            return 271;
        }

        public static String MdEntrySizeMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final IntQty32Decoder mdEntrySize = new IntQty32Decoder();

        public IntQty32Decoder mdEntrySize()
        {
            mdEntrySize.wrap(buffer, offset + 24, actingVersion);
            return mdEntrySize;
        }

        public static int NumberOfOrdersId()
        {
            return 346;
        }

        public static String NumberOfOrdersMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static int numberOfOrdersNullValue()
        {
            return 65535;
        }

        public static int numberOfOrdersMinValue()
        {
            return 0;
        }

        public static int numberOfOrdersMaxValue()
        {
            return 65534;
        }

        public int numberOfOrders()
        {
            return CodecUtil.uint16Get(buffer, offset + 28, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int MdUpdateActionId()
        {
            return 279;
        }

        public static String MdUpdateActionMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public MDUpdateAction mdUpdateAction()
        {
            return MDUpdateAction.get(CodecUtil.uint8Get(buffer, offset + 30));
        }


        public static int RptSeqId()
        {
            return 83;
        }

        public static String RptSeqMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static short rptSeqNullValue()
        {
            return (short)255;
        }

        public static short rptSeqMinValue()
        {
            return (short)0;
        }

        public static short rptSeqMaxValue()
        {
            return (short)254;
        }

        public short rptSeq()
        {
            return CodecUtil.uint8Get(buffer, offset + 31);
        }


        public static int AggressorSideId()
        {
            return 5797;
        }

        public static String AggressorSideMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public Side aggressorSide()
        {
            return Side.get(CodecUtil.charGet(buffer, offset + 32));
        }


        public static int MdEntryTypeId()
        {
            return 269;
        }

        public static String MdEntryTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public MDEntryType mdEntryType()
        {
            return MDEntryType.get(CodecUtil.charGet(buffer, offset + 33));
        }

    }
}
