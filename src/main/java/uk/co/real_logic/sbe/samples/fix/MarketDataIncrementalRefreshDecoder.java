/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.samples.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.DirectBuffer;

@GroupOrder({MarketDataIncrementalRefreshDecoder.EntriesDecoder.class})
public class MarketDataIncrementalRefreshDecoder
{
    public static final int BLOCK_LENGTH = 2;
    public static final int TEMPLATE_ID = 88;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final MarketDataIncrementalRefreshDecoder parentMessage = this;
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

    public MarketDataIncrementalRefreshDecoder wrap(
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

    public static int TradeDateId()
    {
        return 75;
    }

    public static String TradeDateMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static int tradeDateNullValue()
    {
        return 65535;
    }

    public static int tradeDateMinValue()
    {
        return 0;
    }

    public static int tradeDateMaxValue()
    {
        return 65534;
    }

    public int tradeDate()
    {
        return CodecUtil.uint16Get(buffer, offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    private final EntriesDecoder entries = new EntriesDecoder();

    public static long entriesDecoderId()
    {
        return 268;
    }

    public EntriesDecoder entries()
    {
        entries.wrap(parentMessage, buffer, actingVersion);
        return entries;
    }

    public static class EntriesDecoder
    implements Iterable<EntriesDecoder>, java.util.Iterator<EntriesDecoder>
    {
        private static final int HEADER_SIZE = 3;
        private final GroupSizeEncodingDecoder dimensions = new GroupSizeEncodingDecoder();
        private MarketDataIncrementalRefreshDecoder parentMessage;
        private DirectBuffer buffer;
        private int blockLength;
        private int actingVersion;
        private int count;
        private int index;
        private int offset;

        public void wrap(
            final MarketDataIncrementalRefreshDecoder parentMessage, final DirectBuffer buffer, final int actingVersion)
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
            return 82;
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
        public java.util.Iterator<EntriesDecoder> iterator()
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
        public EntriesDecoder next()
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
            return MDUpdateAction.get(CodecUtil.uint8Get(buffer, offset + 0));
        }


        public static int MdPriceLevelId()
        {
            return 1023;
        }

        public static String MdPriceLevelMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "MDPriceLevel";
            }

            return "";
        }

        public static short mdPriceLevelNullValue()
        {
            return (short)255;
        }

        public static short mdPriceLevelMinValue()
        {
            return (short)0;
        }

        public static short mdPriceLevelMaxValue()
        {
            return (short)254;
        }

        public short mdPriceLevel()
        {
            return CodecUtil.uint8Get(buffer, offset + 1);
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
            return MDEntryType.get(CodecUtil.charGet(buffer, offset + 2));
        }


        public static int SecurityIdSourceId()
        {
            return 22;
        }

        public static String SecurityIdSourceMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "SecurityID";
            }

            return "";
        }

        public static byte securityIdSourceNullValue()
        {
            return (byte)0;
        }

        public static byte securityIdSourceMinValue()
        {
            return (byte)32;
        }

        public static byte securityIdSourceMaxValue()
        {
            return (byte)126;
        }

        public byte securityIdSource()
        {
            return CodecUtil.charGet(buffer, offset + 3);
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
                case SEMANTIC_TYPE: return "InstrumentID";
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
            return CodecUtil.uint64Get(buffer, offset + 4, java.nio.ByteOrder.LITTLE_ENDIAN);
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
                case SEMANTIC_TYPE: return "SequenceNumber";
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
            return CodecUtil.uint8Get(buffer, offset + 12);
        }


        public static int QuoteConditionId()
        {
            return 276;
        }

        public static String QuoteConditionMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final QuoteConditionDecoder quoteCondition = new QuoteConditionDecoder();

        public QuoteConditionDecoder quoteCondition()
        {
            quoteCondition.wrap(buffer, offset + 13, actingVersion);
            return quoteCondition;
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
                case SEMANTIC_TYPE: return "Price";
            }

            return "";
        }

        private final Decimal64Decoder mdEntryPx = new Decimal64Decoder();

        public Decimal64Decoder mdEntryPx()
        {
            mdEntryPx.wrap(buffer, offset + 14, actingVersion);
            return mdEntryPx;
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
                case SEMANTIC_TYPE: return "NumberOfOrders";
            }

            return "";
        }

        public static long numberOfOrdersNullValue()
        {
            return 4294967294L;
        }

        public static long numberOfOrdersMinValue()
        {
            return 0L;
        }

        public static long numberOfOrdersMaxValue()
        {
            return 4294967293L;
        }

        public long numberOfOrders()
        {
            return CodecUtil.uint32Get(buffer, offset + 22, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int MdEntryTimeId()
        {
            return 273;
        }

        public static String MdEntryTimeMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static long mdEntryTimeNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long mdEntryTimeMinValue()
        {
            return 0x0L;
        }

        public static long mdEntryTimeMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long mdEntryTime()
        {
            return CodecUtil.uint64Get(buffer, offset + 26, java.nio.ByteOrder.LITTLE_ENDIAN);
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
            mdEntrySize.wrap(buffer, offset + 34, actingVersion);
            return mdEntrySize;
        }

        public static int TradingSessionIdId()
        {
            return 336;
        }

        public static String TradingSessionIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public MarketStateIdentifier tradingSessionId()
        {
            return MarketStateIdentifier.get(CodecUtil.uint8Get(buffer, offset + 38));
        }


        public static int NetChgPrevDayId()
        {
            return 451;
        }

        public static String NetChgPrevDayMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final Decimal64Decoder netChgPrevDay = new Decimal64Decoder();

        public Decimal64Decoder netChgPrevDay()
        {
            netChgPrevDay.wrap(buffer, offset + 39, actingVersion);
            return netChgPrevDay;
        }

        public static int TickDirectionId()
        {
            return 274;
        }

        public static String TickDirectionMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public TickDirection tickDirection()
        {
            return TickDirection.get(CodecUtil.uint8Get(buffer, offset + 47));
        }


        public static int OpenCloseSettleFlagId()
        {
            return 286;
        }

        public static String OpenCloseSettleFlagMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public OpenCloseSettleFlag openCloseSettleFlag()
        {
            return OpenCloseSettleFlag.get(CodecUtil.uint16Get(buffer, offset + 48, java.nio.ByteOrder.LITTLE_ENDIAN));
        }


        public static int SettleDateId()
        {
            return 64;
        }

        public static String SettleDateMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static long settleDateNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long settleDateMinValue()
        {
            return 0x0L;
        }

        public static long settleDateMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long settleDate()
        {
            return CodecUtil.uint64Get(buffer, offset + 50, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int TradeConditionId()
        {
            return 277;
        }

        public static String TradeConditionMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final TradeConditionDecoder tradeCondition = new TradeConditionDecoder();

        public TradeConditionDecoder tradeCondition()
        {
            tradeCondition.wrap(buffer, offset + 58, actingVersion);
            return tradeCondition;
        }

        public static int TradeVolumeId()
        {
            return 1020;
        }

        public static String TradeVolumeMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final IntQty32Decoder tradeVolume = new IntQty32Decoder();

        public IntQty32Decoder tradeVolume()
        {
            tradeVolume.wrap(buffer, offset + 59, actingVersion);
            return tradeVolume;
        }

        public static int MdQuoteTypeId()
        {
            return 1070;
        }

        public static String MdQuoteTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public MDQuoteType mdQuoteType()
        {
            return MDQuoteType.get(CodecUtil.uint8Get(buffer, offset + 63));
        }


        public static int FixingBracketId()
        {
            return 5790;
        }

        public static String FixingBracketMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static long fixingBracketNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long fixingBracketMinValue()
        {
            return 0x0L;
        }

        public static long fixingBracketMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long fixingBracket()
        {
            return CodecUtil.uint64Get(buffer, offset + 64, java.nio.ByteOrder.LITTLE_ENDIAN);
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
            return Side.get(CodecUtil.charGet(buffer, offset + 72));
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
            return MatchEventIndicator.get(CodecUtil.charGet(buffer, offset + 73));
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
                case SEMANTIC_TYPE: return "ExecID";
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
            return CodecUtil.uint64Get(buffer, offset + 74, java.nio.ByteOrder.LITTLE_ENDIAN);
        }

    }
}
