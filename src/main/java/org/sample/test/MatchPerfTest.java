package org.sample.test;

import org.openjdk.jmh.annotations.*;
import org.sample.*;
import org.sample.queries.NextQuery;
import org.sample.queries.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;
import static org.sample.Column.Type.DOUBLE;
import static org.sample.Column.Type.STRING;
import static org.sample.Operand.Operation.GREATER;
import static org.sample.Operand.Operation.LESS;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@OutputTimeUnit(TimeUnit.MICROSECONDS)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class MatchPerfTest {


    @Param(value = {"3", "10", "20", "100"})
    private int columns;

    private final DataBase db = new DataBase();

    private NextQuery query;
        private Random r = new Random();
//    private Random r = new Random(1);
    private Row testRow;

    public MatchPerfTest() {
    }

    public MatchPerfTest(int columns) {
        this.columns = columns;
    }

    @Setup(Level.Trial)
    public void init() throws DBExecption {
        Table table = db.createTable("table")
                .addColumn("name", STRING);

        range(1, columns).forEach(i -> table.addColumn("col-" + i, DOUBLE));

        List<Comparable> values = new ArrayList<>();
        values.add("test");
        values.addAll(range(1, columns - 1)
                .mapToObj(v -> 1000.0 + r.nextInt(100))
                .collect(Collectors.toList()));

        testRow = db.insert("table", values.toArray(new Comparable[values.size()]));

        final double avg = 1050.0;

        query = db.select("table").where(nextCol(), nextOp(), avg);
        int colsInQuery = r.nextInt(columns / 2) - 1;
        if (colsInQuery > 0) {
            range(1, colsInQuery).forEach(i -> query.and(nextCol(), nextOp(), avg));
        }

        System.out.println(testRow);
        System.out.println(query);
    }

    private String nextCol() {
        return "col-" + (1 + r.nextInt(columns - 2));
    }

    private Operand.Operation nextOp() {
        return r.nextBoolean() ? GREATER : LESS;
    }

    @Benchmark
    public boolean match() throws DBExecption {
        return ((Query) query).match(testRow);
    }

//    @Benchmark
//    public List<Row> select() throws DBExecption {
//        return query.get();
//    }

    public static void main(String[] args) throws DBExecption {
        final MatchPerfTest test = new MatchPerfTest(10);
        test.init();
        System.out.println(test.match());
    }
}
