package org.sample.test;

import org.openjdk.jmh.annotations.*;
import org.sample.DBExecption;
import org.sample.DataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.sample.Column.Type.DOUBLE;
import static org.sample.Column.Type.STRING;
import static org.sample.Operand.Operation.EQUALS;

@State(Scope.Group)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@BenchmarkMode(Mode.Throughput)
//@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 3)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
public class SubscrPerfTest1 {

    private final DataBase db = new DataBase();

    @Param(value = {"10", "100"})
    private int totalRows;

//    @Param(value = {"10", "1000", "10000", "100000"})
//    @Param(value = {"10000", "100000", "1000000"})
    @Param(value = {"1000000", "10000000"})
    private int subscribers;

//    @Param(value = {"100", "1000"})
    private int updates = 1000;

    private CountDownLatch resultWaiter;
    private final Random random = new Random(1);

    private long[] ids;
    private double[] prices;
    private int idx;

    public SubscrPerfTest1() {
    }

    public SubscrPerfTest1(int totalRows, int subscribers, int updates) {
        this.totalRows = totalRows;
        this.subscribers = subscribers;
        this.updates = updates;

        System.out.println("totalRows = " + totalRows);
        System.out.println("subscribers = " + subscribers);
        System.out.println("updates = " + updates);
    }


    @Setup(Level.Trial)
    public void init() throws DBExecption {
        db.createTable("market-data")
                .addColumn("symbol", STRING)
                .addColumn("bid", DOUBLE)
                .addColumn("ask", DOUBLE)
                .addColumn("open", DOUBLE)
                .addColumn("high", DOUBLE)
                .addColumn("low", DOUBLE)
                .addColumn("close", DOUBLE)
                .addColumn("last", DOUBLE);

        for (int i = 2; i < totalRows + 2; i++) {
            db.insert("market-data", "symb" + i);
        }

        List<Long> subscribed = new ArrayList<>();
        for (int i = 0; i < subscribers; i++) {
            long id = random.nextInt(totalRows);
            subscribed.add(id);
            final String symbol = "symb" + id;
            db.subscribe("market-data", update ->
                    resultWaiter.countDown()).where("symbol", EQUALS, symbol)
                    .get();
        }

        ids = new long[updates];
        prices = new double[updates];
        int executedUpdates = 0;
        for (int i = 0; i < ids.length; i++) {
            long id = random.nextInt(totalRows - 2) + 2;
            ids[i] = id;
            prices[i] = random.nextDouble();
            if (subscribed.contains(id)) executedUpdates++;
        }

        resultWaiter = new CountDownLatch(executedUpdates);
        idx = 0;
    }

    @Group("DB")
    @Benchmark
    public void update() throws DBExecption {
        db.update("market-data", ids[idx], "bid", prices[idx]);
        idx++;
        if (idx >= ids.length) {
            idx = 0;
        }
    }

    @Group("DB")
    @Benchmark
    public void listen() throws InterruptedException {
        resultWaiter.await();
    }

    @TearDown
    public void stopExecutor() throws InterruptedException {
//        db.notifier.shutdownNow();
        db.localExecutor.interrupt();
        System.out.println("Executor stopped");
    }


    public static String printStackTrace(StackTraceElement[] elems) {
        if (elems == null || elems.length == 0) return "";

        return Arrays.stream(elems).map(StackTraceElement::toString)
                .collect(Collectors.joining("\n\t\t\t", "\t\t", "")) + "\n";

    }

    public static void main1(String[] args) throws DBExecption, InterruptedException {
        SubscrPerfTest1 test = new SubscrPerfTest1(100, 10, 1000);
        System.out.println("Init.");
        test.init();

        System.out.println("Update.");
        test.update();
        System.out.println("Listen.");
        test.listen();
        System.out.println("Done.");

        Thread.sleep(1000);

        test.stopExecutor();

        System.out.println("Running threads:");
        Thread.getAllStackTraces().keySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()))
                .forEach(t ->
                        System.out.println(t.getPriority() + ".\t" + t.getName() + " #" + t.getId() + "\t" +
                                t.getState() + "\t" +
                                "[" + (t.isDaemon() ? "Daemon" : "Regular") + "]" +
                                "\n" + printStackTrace(t.getStackTrace())));

//        System.exit(1);
    }


}
