package uk.co.real_logic.quickfix;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.Scope;
import quickfix.*;
import quickfix.Group;
import quickfix.field.*;
import quickfix.fix44.MarketDataIncrementalRefresh;

import java.util.List;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class MarketDataBenchmark {

    private static DataDictionary DICTIONARY;

    static {
        try {
            DICTIONARY = new DataDictionary("./etc/FIX44.xml");
        } catch (ConfigError configError) {
            configError.printStackTrace();
        }
    }

    private static final MessageFactory FACTORY = new DefaultMessageFactory();

    @State(Scope.Benchmark)
    public static class MyState {
        final String mesToDecode = MarketDataBenchmark.encode();
        final FieldPool pool = new FieldPool();
    }


    @Benchmark
    public String testEncode() {
        return encode();
    }

    @Benchmark
    public String testEncodeWithPool(final MyState state) {
        final FieldPool pool = state.pool;
        return encode(pool);
    }


    @Benchmark
    public MarketDataIncrementalRefresh testDecode(final MyState state) throws InvalidMessage, FieldNotFound {
        final String mesToDecode = state.mesToDecode;
        return decode(mesToDecode);
    }

    @Benchmark
    public MarketDataIncrementalRefresh testDecodeWithPool(final MyState state) throws InvalidMessage, FieldNotFound {
        final String mesToDecode = state.mesToDecode;
        final FieldPool pool = state.pool;
        return decode(mesToDecode, pool);
    }


    public static String encode() {

        final MarketDataIncrementalRefresh marketData = new MarketDataIncrementalRefresh();
        marketData.set(new MDReqID("1234"));

        MarketDataIncrementalRefresh.NoMDEntries mdIncGrp = new MarketDataIncrementalRefresh.NoMDEntries();
        mdIncGrp.set(new SecurityID("56789"));
        mdIncGrp.set(new MDEntryPx(50));
        mdIncGrp.set(new MDEntrySize(50));
        mdIncGrp.set(new NumberOfOrders(1));
        mdIncGrp.set(new MDUpdateAction(MDUpdateAction.NEW));
        mdIncGrp.set(new MDEntryType(MDEntryType.BID));
        marketData.addGroup(mdIncGrp);

        mdIncGrp = new MarketDataIncrementalRefresh.NoMDEntries();
        mdIncGrp.set(new SecurityID("56789"));
        mdIncGrp.set(new MDEntryPx(50));
        mdIncGrp.set(new MDEntrySize(50));
        mdIncGrp.set(new NumberOfOrders(1));
        mdIncGrp.set(new MDUpdateAction(MDUpdateAction.NEW));
        mdIncGrp.set(new MDEntryType(MDEntryType.OFFER));
        marketData.addGroup(mdIncGrp);

        return marketData.toString();
    }


    public static String encode(FieldPool pool) {
        final MarketDataIncrementalRefresh marketData = pool.marketDataIncrementalRefresh;
        return marketData.toString();
    }


    public MarketDataIncrementalRefresh decode(String text) throws InvalidMessage, FieldNotFound {

//        new MarketDataIncrementalRefresh()
        MarketDataIncrementalRefresh marketData = (MarketDataIncrementalRefresh) MessageUtils.parse(FACTORY, DICTIONARY, text);
        marketData.get(new MDReqID());
        List<Group> groups = marketData.getGroups(NoMDEntries.FIELD);
        Group gp1 = groups.get(0);
        gp1.getField(new SecurityID());
        gp1.getField(new MDEntryPx());
        gp1.getField(new MDEntrySize());
        gp1.getField(new NumberOfOrders());
        gp1.getField(new MDUpdateAction());
        gp1.getField(new MDEntryType());

        Group gp2 = groups.get(1);
        gp2.getField(new SecurityID());
        gp2.getField(new MDEntryPx());
        gp2.getField(new MDEntrySize());
        gp2.getField(new NumberOfOrders());
        gp2.getField(new MDUpdateAction());
        gp2.getField(new MDEntryType());
        return marketData;
    }


    public MarketDataIncrementalRefresh decode(String text, FieldPool pool) throws InvalidMessage, FieldNotFound {
//        new MarketDataIncrementalRefresh()
        MarketDataIncrementalRefresh marketData = (MarketDataIncrementalRefresh) MessageUtils.parse(FACTORY, DICTIONARY, text);
        marketData.get(pool.mdReqEmpty);
        List<Group> groups = marketData.getGroups(NoMDEntries.FIELD);
        Group gp1 = groups.get(0);
        gp1.getField(pool.securityIdEmpty);
        gp1.getField(pool.mdEntryPx);
        gp1.getField(pool.mdEntrySize);
        gp1.getField(pool.numOfOrders);
        gp1.getField(pool.mdUpdateAction);
        gp1.getField(pool.mdEtryTypeEmpty);

        Group gp2 = groups.get(1);
        gp2.getField(pool.securityIdEmpty);
        gp2.getField(pool.mdEntryPx);
        gp2.getField(pool.mdEntrySize);
        gp2.getField(pool.numOfOrders);
        gp2.getField(pool.mdUpdateAction);
        gp2.getField(pool.mdEtryTypeEmpty);
        return marketData;
    }


    public static class FieldPool {

        final MarketDataIncrementalRefresh marketDataIncrementalRefresh;

        final MDReqID mdReqEmpty = new MDReqID();
        final SecurityID securityIdEmpty = new SecurityID();
        final MDEntryPx mdEntryPxEmpty = new MDEntryPx();
        final MDEntrySize mdEntrySizeEmpty = new MDEntrySize();
        final NumberOfOrders numOfOrdersEmpty = new NumberOfOrders();
        final MDUpdateAction mdUpdateActionEmpty = new MDUpdateAction();
        final MDEntryType mdEtryTypeEmpty = new MDEntryType();

        final MDReqID mdReq = new MDReqID("1234");
        final SecurityID securityId = new SecurityID("56789");
        final MDEntryPx mdEntryPx = new MDEntryPx(50);
        final MDEntrySize mdEntrySize = new MDEntrySize(10);
        final NumberOfOrders numOfOrders = new NumberOfOrders(1);
        final MDUpdateAction mdUpdateAction = new MDUpdateAction(MDUpdateAction.NEW);
        final MDEntryType mdEtryTypeOffer = new MDEntryType(MDEntryType.OFFER);
        final MDEntryType mdEtryTypeBid = new MDEntryType(MDEntryType.BID);

        public FieldPool() {
            marketDataIncrementalRefresh = new MarketDataIncrementalRefresh();

            marketDataIncrementalRefresh.set(mdReq);

            MarketDataIncrementalRefresh.NoMDEntries mdIncGrp = new MarketDataIncrementalRefresh.NoMDEntries();
//        mdIncGrp.set(new TradeID("1234"));
            mdIncGrp.set(securityId);
            mdIncGrp.set(mdEntryPx);
            mdIncGrp.set(mdEntrySize);
            mdIncGrp.set(numOfOrders);
            mdIncGrp.set(mdUpdateAction);
//        mdIncGrp.set(new RptSeq(1));
//        mdIncGrp.set(new AggressorIndicator());
            mdIncGrp.set(mdEtryTypeBid);
            marketDataIncrementalRefresh.addGroup(mdIncGrp);

            mdIncGrp = new MarketDataIncrementalRefresh.NoMDEntries();
//        mdIncGrp.set(new TradeID("1234"));
            mdIncGrp.set(securityId);
            mdIncGrp.set(mdEntryPx);
            mdIncGrp.set(mdEntrySize);
            mdIncGrp.set(numOfOrders);
            mdIncGrp.set(mdUpdateAction);
//        mdIncGrp.set(new RptSeq(1));
//        mdIncGrp.set(new AggressorIndicator());
            mdIncGrp.set(mdEtryTypeOffer);
            marketDataIncrementalRefresh.addGroup(mdIncGrp);
        }
    }


}
