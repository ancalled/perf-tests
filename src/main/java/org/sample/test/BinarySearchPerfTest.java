package org.sample.test;

import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;
import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class BinarySearchPerfTest {

    @Param({"1024", "262144"})
//    @Param({"256", "1024", "4096", "16384", "65536", "262144"})
            int size;

    @Param({"0.1", "0.3", "0.5", "1"})
    double uniqCoef;

    @Param({"10000"})
    int bound;

    List<Item<Integer>> itemsList;
    HashMap<Integer, Items<Integer>> hashMap = new HashMap<>();
    ConcurrentHashMap<Integer, Items<Integer>> conHashMap = new ConcurrentHashMap<>();
    TreeMap<Integer, Items<Integer>> treeMap = new TreeMap<>();
    ChronicleMap<Integer, Items> chronicleMap = ChronicleMapBuilder
            .of(Integer.class, Items.class)
            .create();

    int searchValue;

    public BinarySearchPerfTest() {
    }

    public BinarySearchPerfTest(int size) {
        this.size = size;
    }

    @Setup(Level.Trial)
    public void init() {
        Random random = new Random();

        List<Integer> values = IntStream.range(0, (int) (size * uniqCoef))
                .mapToObj(i -> random.nextInt(bound))
                .collect(Collectors.toList());

        itemsList = IntStream.range(0, size)
                .mapToObj(l -> new Item<>(l, values.get(random.nextInt(values.size()))))
                .collect(Collectors.toList());

        searchValue = itemsList.get(random.nextInt(itemsList.size())).value;

        itemsList.sort((t1, t2) -> t1.value.compareTo(t2.value));
        itemsList.forEach(i -> {
            Items<Integer> items = hashMap.get(i.value);
            if (items == null) {
                items = new Items<>();
                hashMap.put(i.value, items);
            }
            items.add(i);
        });

        itemsList.forEach(i -> {
            Items<Integer> items = conHashMap.get(i.value);
            if (items == null) {
                items = new Items<>();
                conHashMap.put(i.value, items);
            }
            items.add(i);
        });

        itemsList.forEach(i -> {
            Items<Integer> items = treeMap.get(i.value);
            if (items == null) {
                items = new Items<>();
                treeMap.put(i.value, items);
            }
            items.add(i);
        });

        itemsList.forEach(i -> {
            Items<Integer> items = conHashMap.get(i.value);
            if (items == null) {
                items = new Items<>();
                conHashMap.put(i.value, items);
            }
            items.add(i);
        });


    }


//    @Benchmark
    public List<Item> binarySearch() {
        return binarySearch(itemsList, searchValue);
    }

//    @Benchmark
    public Items<Integer> hashmapSearch() {
        return hashMap.get(searchValue);
    }

    @Benchmark
    public Items<Integer> concurentHashmapSearch() {
        return conHashMap.get(searchValue);
    }

//    @Benchmark
    public Items<Integer> treemapSearch() {
        return treeMap.get(searchValue);
    }


    @Benchmark
    public Items chronicleSearch() {
        return chronicleMap.get(searchValue);
    }


    static class Item<T extends Comparable<T>> {
        long index;
        T value;

        public Item(long index, T value) {
            this.index = index;
            this.value = value;
        }

    }


    static class Items<T extends Comparable<T>> {
        final List<Item<T>> items = new ArrayList<>();

        public void add(Item<T> i) {
            items.add(i);
        }


    }

    private static <T extends Comparable<T>> List<Item> binarySearch(List<Item<T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        List<Item> res = new ArrayList<>();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Item<T> midVal = list.get(mid);
            int cmp = midVal.value.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else {
                for (int i = mid - 1; i >= 0; i--) {
                    Item<T> t = list.get(i);
                    if (t.value.compareTo(key) != 0) break;
                    res.add(t);
                }

                res.add(midVal);

                for (int i = mid + 1; i < list.size(); i++) {
                    Item<T> t = list.get(i);
                    if (t.value.compareTo(key) != 0) break;
                    res.add(t);
                }

                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        BinarySearchPerfTest test = new BinarySearchPerfTest(100);
//        test.init();
//
//        List<Item> res = test.binarySearch();
//        System.out.println(res.stream().map(t -> Long.toString(t.index)).collect(Collectors.joining(", ")));
    }

}
