package org.sample.test;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class BaselineTest2 {

    Random random = new Random(1);

//    @Param({"256", "1024", "4096", "16384", "65536"})
    @Param({"1024", "262144"})
    int size;

    double[] array;
    List<Double> list;

    double toFind;


    @Setup
    public void init() {
        array = new double[size];
        Arrays.fill(array, random.nextDouble());
        toFind = random.nextDouble();
        array[random.nextInt(size)] = toFind;
        list = new ArrayList<>();
        Arrays.stream(array).sorted().forEach(list::add);
    }

    @Benchmark
    public int simpleSearch_array() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == toFind) return i;
        }
        return -1;
    }

    @Benchmark
    public int simpleSearch_list() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == toFind) return i;
        }
        return -1;
    }

    @Benchmark
    public int binarySearch_array() {
        return binarySearch(array, toFind);
    }

    @Benchmark
    public int binarySearch_list() {
        return Collections.binarySearch(list, toFind);
    }


    private static int binarySearch(double[] array, double key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = array[mid];
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }


}
