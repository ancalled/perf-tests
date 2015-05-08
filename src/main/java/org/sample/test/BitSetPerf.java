package org.sample.test;

import org.openjdk.jmh.annotations.*;

import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class BitSetPerf {

    Random random = new Random(1);

    @Param({"20"})
    int size;

//    @Param({"10", "100", "1000"})
    @Param({"20"})
    int bound;

    BitSet first;
    List<BitSet> bitSets;

    int idx = 0;


    @Setup(Level.Trial)
    public void init() {
        bitSets = IntStream.range(0, size)
                .mapToObj(i -> random.nextInt(bound))
                .map(BitSetPerf::toBits)
                .collect(Collectors.toList());
        int maxCard = bitSets.stream().mapToInt(BitSet::cardinality).max().getAsInt();
        first = new BitSet(maxCard);
        first.set(0, maxCard);
    }


    public static BitSet toBits(int val) {
        return BitSet.valueOf(new long[]{val});
    }

    @Benchmark
    public void add() {
        first.and(bitSets.get(idx));
        idx = idx < bitSets.size() - 1 ? idx ++ : 0;
    }

    @Benchmark
    public void or() {
        first.or(bitSets.get(idx));
        idx = idx < bitSets.size() - 1 ? idx ++ : 0;
    }

    @Benchmark
    public void xor() {
        first.or(bitSets.get(idx));
        idx = idx < bitSets.size() - 1 ? idx ++ : 0;
    }

    @Benchmark
    public void cardinality() {
        bitSets.get(idx).cardinality();
        idx = idx < bitSets.size() - 1 ? idx ++ : 0;
    }





}
