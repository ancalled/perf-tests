package uk.co.real_logic.aeron.samples.my.domain;


import uk.co.real_logic.aeron.samples.my.sbe.fix.*;

public class MDIncRefresh implements Item {

    long securityId;
    long sessionId;
    float lastDealPrice;
    float lastDealVolume;

    public MDIncRefresh() {
    }

    public MDIncRefresh(long securityId, float lastDealPrice, float lastDealVolume) {
        this.securityId = securityId;
        this.lastDealPrice = lastDealPrice;
        this.lastDealVolume = lastDealVolume;
    }

    public void serialize(MarketDataIncrementalRefreshEncoder marketData) {

        marketData.tradeDate(987);

        final MarketDataIncrementalRefreshEncoder.EntriesEncoder mdIncGrp = marketData.entriesCount(2);
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
        return "TradeInfo{" +
                "securityId=" + securityId +
                ", sessionId=" + sessionId +
                ", lastDealPrice=" + lastDealPrice +
                ", lastDealVolume=" + lastDealVolume +
                '}';
    }
}
