package uk.co.real_logic.aeron.samples.my.domain;


import uk.co.real_logic.aeron.samples.my.sbe.fix.*;

public class MDIncRefreshTrades implements Item {

    long securityId;
    long sessionId;
    float lastDealPrice;
    float lastDealVolume;

    public MDIncRefreshTrades() {
    }

    public MDIncRefreshTrades(long securityId, double lastDealPrice, double lastDealVolume) {
        this.securityId = securityId;
        this.lastDealPrice = (float) lastDealPrice;
        this.lastDealVolume =(float) lastDealVolume;
    }

    public void serialize(MarketDataIncrementalRefreshTradesEncoder marketData) {

        marketData.transactTime(1234L)
                .eventTimeDelta(987)
                .matchEventIndicator(MatchEventIndicator.END_EVENT);

        final MarketDataIncrementalRefreshTradesEncoder.MdIncGrpEncoder mdIncGrp = marketData.mdIncGrpCount(2);
        mdIncGrp.next();
        mdIncGrp.tradeId(1234L);
        mdIncGrp.securityId(securityId);
        mdIncGrp.mdEntryPx().mantissa(50);
        mdIncGrp.mdEntrySize().mantissa(10);
        mdIncGrp.numberOfOrders(1);
        mdIncGrp.mdUpdateAction(MDUpdateAction.NEW);
        mdIncGrp.rptSeq((short) 1);
        mdIncGrp.aggressorSide(Side.BUY);
        mdIncGrp.mdEntryType(MDEntryType.BID);

        mdIncGrp.next();
        mdIncGrp.tradeId(1234L);
        mdIncGrp.securityId(securityId);
        mdIncGrp.mdEntryPx().mantissa(50);
        mdIncGrp.mdEntrySize().mantissa(10);
        mdIncGrp.numberOfOrders(1);
        mdIncGrp.mdUpdateAction(MDUpdateAction.NEW);
        mdIncGrp.rptSeq((short) 1);
        mdIncGrp.aggressorSide(Side.SELL);
        mdIncGrp.mdEntryType(MDEntryType.OFFER);
    }

    public void deserialize(MarketDataIncrementalRefreshTradesDecoder decoder) {
//        securityId = decoder.securityId();
//        sessionId = decoder.sessionId();
//        lastDealPrice = decoder.lastDealTodayPrice();
//        lastDealVolume = decoder.lastDealTodayVolume();
    }

    @Override
    public String toString() {
        return "MDIncRefreshTrades{" +
                "securityId=" + securityId +
                ", sessionId=" + sessionId +
                ", lastDealPrice=" + lastDealPrice +
                ", lastDealVolume=" + lastDealVolume +
                '}';
    }
}
