package org.sample.test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.sample.Column;
import org.sample.Condition;
import org.sample.Operand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.sample.Column.Type.STRING;
import static org.sample.Operand.Operation.EQUALS;

@State(Scope.Thread)
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class TestConditionCheck {

    private final List<Column> row = new ArrayList<>();
    private final List<Condition> subscr = new ArrayList<>();

    @Param(value = {"3", "10", "25", "100"})
//    @Param(value = {"2", "8", "32"})
//    @Param(value = {"2", "4"})
    private int columns;

    @Param(value = {"10", "100", "1000", "10000"})
//    @Param(value = {"10000", "100000"})
//    @Param(value = {"1000000", "10000000"})
    private int subscribers;

    @Setup
    public void init() {
        final Random rnd = new Random(1);

        row.addAll(range(1, columns)
                .mapToObj(i -> new Column("field" + i, STRING, "val" + i))
                .collect(toList()));

        subscr.addAll(
                range(1, subscribers)
                        .mapToObj(i -> range(1, rnd.nextInt(columns - 1) + 1)
//                                .mapToObj(j -> new Predicate("field" + i, i % 3 > 0 ? EQUALS : NOTEQ, "val" + i))
                                .mapToObj(j -> new Operand("field" + i, EQUALS, "val" + i))
                                .collect(toList()))
                        .map(Condition::new)
                        .collect(toList()));
    }


    @Benchmark
    public void search(Blackhole blackhole) {
        blackhole.consume(subscr.stream()
                .filter(c -> c.matches(row))
                .collect(Collectors.toList()));
    }

    public List<Condition> search() {
        return subscr.stream()
                .filter(c -> c.matches(row))
                .collect(Collectors.toList());
    }


}
