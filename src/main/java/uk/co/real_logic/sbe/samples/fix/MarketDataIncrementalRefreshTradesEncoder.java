/* Generated SBE (Simple Binary Encoding) message codec */
package uk.co.real_logic.sbe.samples.fix;

import uk.co.real_logic.sbe.codec.java.*;
import uk.co.real_logic.agrona.MutableDirectBuffer;

@GroupOrder({MarketDataIncrementalRefreshTradesEncoder.MdIncGrpEncoder.class})
public class MarketDataIncrementalRefreshTradesEncoder
{
    public static final int BLOCK_LENGTH = 11;
    public static final int TEMPLATE_ID = 2;
    public static final int SCHEMA_ID = 2;
    public static final int SCHEMA_VERSION = 0;

    private final MarketDataIncrementalRefreshTradesEncoder parentMessage = this;
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

    public MarketDataIncrementalRefreshTradesEncoder wrap(final MutableDirectBuffer buffer, final int offset)
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
    public MarketDataIncrementalRefreshTradesEncoder transactTime(final long value)
    {
        CodecUtil.uint64Put(buffer, offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
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
    public MarketDataIncrementalRefreshTradesEncoder eventTimeDelta(final int value)
    {
        CodecUtil.uint16Put(buffer, offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }
    public MarketDataIncrementalRefreshTradesEncoder matchEventIndicator(final MatchEventIndicator value)
    {
        CodecUtil.charPut(buffer, offset + 10, value.value());
        return this;
    }

    private final MdIncGrpEncoder mdIncGrp = new MdIncGrpEncoder();

    public static long mdIncGrpId()
    {
        return 268;
    }

    public MdIncGrpEncoder mdIncGrpCount(final int count)
    {
        mdIncGrp.wrap(parentMessage, buffer, count);
        return mdIncGrp;
    }

    public static class MdIncGrpEncoder
    {
        private static final int HEADER_SIZE = 3;
        private final GroupSizeEncodingEncoder dimensions = new GroupSizeEncodingEncoder();
        private MarketDataIncrementalRefreshTradesEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int blockLength;
        private int actingVersion;
        private int count;
        private int index;
        private int offset;

        public void wrap(final MarketDataIncrementalRefreshTradesEncoder parentMessage, final MutableDirectBuffer buffer, final int count)
        {
            this.parentMessage = parentMessage;
            this.buffer = buffer;
            actingVersion = SCHEMA_VERSION;
            dimensions.wrap(buffer, parentMessage.limit(), actingVersion);
            dimensions.blockLength((int)34);
            dimensions.numInGroup((short)count);
            index = -1;
            this.count = count;
            blockLength = 34;
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

        public MdIncGrpEncoder next()
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
        public MdIncGrpEncoder tradeId(final long value)
        {
            CodecUtil.uint64Put(buffer, offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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
        public MdIncGrpEncoder securityId(final long value)
        {
            CodecUtil.uint64Put(buffer, offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }

        private final Decimal64Encoder mdEntryPx = new Decimal64Encoder();

        public Decimal64Encoder mdEntryPx()
        {
            mdEntryPx.wrap(buffer, offset + 16, actingVersion);
            return mdEntryPx;
        }

        private final IntQty32Encoder mdEntrySize = new IntQty32Encoder();

        public IntQty32Encoder mdEntrySize()
        {
            mdEntrySize.wrap(buffer, offset + 24, actingVersion);
            return mdEntrySize;
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
        public MdIncGrpEncoder numberOfOrders(final int value)
        {
            CodecUtil.uint16Put(buffer, offset + 28, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }
        public MdIncGrpEncoder mdUpdateAction(final MDUpdateAction value)
        {
            CodecUtil.uint8Put(buffer, offset + 30, value.value());
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
        public MdIncGrpEncoder rptSeq(final short value)
        {
            CodecUtil.uint8Put(buffer, offset + 31, value);
            return this;
        }
        public MdIncGrpEncoder aggressorSide(final Side value)
        {
            CodecUtil.charPut(buffer, offset + 32, value.value());
            return this;
        }
        public MdIncGrpEncoder mdEntryType(final MDEntryType value)
        {
            CodecUtil.charPut(buffer, offset + 33, value.value());
            return this;
        }
    }
}
