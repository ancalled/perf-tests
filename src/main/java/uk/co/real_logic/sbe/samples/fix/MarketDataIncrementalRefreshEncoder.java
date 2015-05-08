/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.samples.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

@GroupOrder({MarketDataIncrementalRefreshEncoder.EntriesEncoder.class})
public class MarketDataIncrementalRefreshEncoder
{
    public static final int BLOCK_LENGTH = 2;
    public static final int TEMPLATE_ID = 88;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final MarketDataIncrementalRefreshEncoder parentMessage = this;
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
        return "X";
    }

    public int offset()
    {
        return offset;
    }

    public MarketDataIncrementalRefreshEncoder wrap(final MutableDirectBuffer buffer, final int offset)
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
    public MarketDataIncrementalRefreshEncoder tradeDate(final int value)
    {
        CodecUtil.uint16Put(buffer, offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    private final EntriesEncoder entries = new EntriesEncoder();

    public static long entriesId()
    {
        return 268;
    }

    public EntriesEncoder entriesCount(final int count)
    {
        entries.wrap(parentMessage, buffer, count);
        return entries;
    }

    public static class EntriesEncoder
    {
        private static final int HEADER_SIZE = 3;
        private final GroupSizeEncodingEncoder dimensions = new GroupSizeEncodingEncoder();
        private MarketDataIncrementalRefreshEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int blockLength;
        private int actingVersion;
        private int count;
        private int index;
        private int offset;

        public void wrap(final MarketDataIncrementalRefreshEncoder parentMessage, final MutableDirectBuffer buffer, final int count)
        {
            this.parentMessage = parentMessage;
            this.buffer = buffer;
            actingVersion = SCHEMA_VERSION;
            dimensions.wrap(buffer, parentMessage.limit(), actingVersion);
            dimensions.blockLength((int)82);
            dimensions.numInGroup((short)count);
            index = -1;
            this.count = count;
            blockLength = 82;
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

        public EntriesEncoder next()
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
        public EntriesEncoder mdUpdateAction(final MDUpdateAction value)
        {
            CodecUtil.uint8Put(buffer, offset + 0, value.value());
            return this;
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
        public EntriesEncoder mdPriceLevel(final short value)
        {
            CodecUtil.uint8Put(buffer, offset + 1, value);
            return this;
        }
        public EntriesEncoder mdEntryType(final MDEntryType value)
        {
            CodecUtil.charPut(buffer, offset + 2, value.value());
            return this;
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
        public EntriesEncoder securityIdSource(final byte value)
        {
            CodecUtil.charPut(buffer, offset + 3, value);
            return this;
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
        public EntriesEncoder securityId(final long value)
        {
            CodecUtil.uint64Put(buffer, offset + 4, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
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
        public EntriesEncoder rptSeq(final short value)
        {
            CodecUtil.uint8Put(buffer, offset + 12, value);
            return this;
        }

        private final QuoteConditionEncoder quoteCondition = new QuoteConditionEncoder();

        public QuoteConditionEncoder quoteCondition()
        {
            quoteCondition.wrap(buffer, offset + 13, actingVersion);
            return quoteCondition;
        }

        private final Decimal64Encoder mdEntryPx = new Decimal64Encoder();

        public Decimal64Encoder mdEntryPx()
        {
            mdEntryPx.wrap(buffer, offset + 14, actingVersion);
            return mdEntryPx;
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
        public EntriesEncoder numberOfOrders(final long value)
        {
            CodecUtil.uint32Put(buffer, offset + 22, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
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
        public EntriesEncoder mdEntryTime(final long value)
        {
            CodecUtil.uint64Put(buffer, offset + 26, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }

        private final IntQty32Encoder mdEntrySize = new IntQty32Encoder();

        public IntQty32Encoder mdEntrySize()
        {
            mdEntrySize.wrap(buffer, offset + 34, actingVersion);
            return mdEntrySize;
        }
        public EntriesEncoder tradingSessionId(final MarketStateIdentifier value)
        {
            CodecUtil.uint8Put(buffer, offset + 38, value.value());
            return this;
        }

        private final Decimal64Encoder netChgPrevDay = new Decimal64Encoder();

        public Decimal64Encoder netChgPrevDay()
        {
            netChgPrevDay.wrap(buffer, offset + 39, actingVersion);
            return netChgPrevDay;
        }
        public EntriesEncoder tickDirection(final TickDirection value)
        {
            CodecUtil.uint8Put(buffer, offset + 47, value.value());
            return this;
        }
        public EntriesEncoder openCloseSettleFlag(final OpenCloseSettleFlag value)
        {
            CodecUtil.uint16Put(buffer, offset + 48, value.value(), java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
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
        public EntriesEncoder settleDate(final long value)
        {
            CodecUtil.uint64Put(buffer, offset + 50, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }

        private final TradeConditionEncoder tradeCondition = new TradeConditionEncoder();

        public TradeConditionEncoder tradeCondition()
        {
            tradeCondition.wrap(buffer, offset + 58, actingVersion);
            return tradeCondition;
        }

        private final IntQty32Encoder tradeVolume = new IntQty32Encoder();

        public IntQty32Encoder tradeVolume()
        {
            tradeVolume.wrap(buffer, offset + 59, actingVersion);
            return tradeVolume;
        }
        public EntriesEncoder mdQuoteType(final MDQuoteType value)
        {
            CodecUtil.uint8Put(buffer, offset + 63, value.value());
            return this;
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
        public EntriesEncoder fixingBracket(final long value)
        {
            CodecUtil.uint64Put(buffer, offset + 64, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }
        public EntriesEncoder aggressorSide(final Side value)
        {
            CodecUtil.charPut(buffer, offset + 72, value.value());
            return this;
        }
        public EntriesEncoder matchEventIndicator(final MatchEventIndicator value)
        {
            CodecUtil.charPut(buffer, offset + 73, value.value());
            return this;
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
        public EntriesEncoder tradeId(final long value)
        {
            CodecUtil.uint64Put(buffer, offset + 74, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }
    }
}
