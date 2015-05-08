package org.sample.test;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class BaselineTest {

    Random random = new Random(1);

    double dblVal = random.nextDouble();
    double dblVal2 = dblVal;
    double dblVal3 = random.nextDouble();
    Double dblObj1 = dblVal;
    Double dblObj2 = dblVal;

    long longVal = random.nextLong();
    long longVal2 = random.nextLong();

    @Benchmark
    public boolean eqDouble() {
        return dblVal == dblVal2;
    }

    @Benchmark
    public boolean eqDouble2() {
        return dblObj1.equals(dblObj2);
    }

    @Benchmark
    public boolean noteqDouble() {
        return dblVal != dblVal2;
    }

    @Benchmark
    public boolean lessDouble() {
        return dblVal < dblVal3;
    }

    @Benchmark
    public boolean lessDouble2() {
        return dblObj1.compareTo(dblObj2) < 0;
    }

    @Benchmark
    public boolean moreDouble() {
        return dblVal > dblVal2;
    }

    @Benchmark
    public boolean moreDouble2() {
        return dblObj1.compareTo(dblObj2) > 0;
    }


    @Benchmark
    public boolean eqLong() {
        return longVal == longVal2;
    }

}
