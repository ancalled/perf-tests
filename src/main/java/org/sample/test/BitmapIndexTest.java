package org.sample.test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BitmapIndexTest {

    public static final int BIT_IN_LONG = 64;
    List<BitSet> masks = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
        BitSet bs = toBits(item.value);
        for (int i = 0; i < bs.size(); i++) {
            BitSet mask;
            if (masks.size() <= i) {
                mask = new BitSet();
                masks.add(mask);
            } else {
                mask = masks.get(i);
            }
            mask.set(items.size() - 1, bs.get(i));
        }
    }

    public List<Item> findByValue(long value) {
//        BitSet bs = toBits(value);
        BitSet bs = new BitSet();
        bs.set(0, BIT_IN_LONG);
        masks.forEach(bs::and);
        List<Item> res = new ArrayList<>();
        for (int i = bs.nextSetBit(0); i < BIT_IN_LONG && i > 0; i = bs.nextClearBit(i)) {
            res.add(items.get(i));
        }
        return res;
    }

    public static class Item {
        String name;
        long value;

        public Item(String name, long value) {
            this.name = name;
            this.value = value;
        }
    }

    public static BitSet toBits(long val) {
        return BitSet.valueOf(new long[]{val});
    }

    public static void main(String[] args) {

//        List<BitSet> bitsSets = IntStream.range(0, 10)
//                .mapToObj(BitSetTest::toBits)
//                .collect(Collectors.toList());
//        bitsSets.forEach(System.out::println);

//        BitSet bs1 = toBits(4);
//        System.out.println(bs1);
//        BitSet bs2 = toBits(5);
//        System.out.println(bs2);
//        bs1.and(bs2);
//
//
//        System.out.println(bs1);

        BitmapIndexTest test = new BitmapIndexTest();
        test.add(new Item("item-1", 425));
//        test.add(new Item("item-2", 1041));
        test.add(new Item("item-3", 301));
//        test.add(new Item("item-4", 512));
//        test.add(new Item("item-5", 151));
        test.add(new Item("item-6", 301));
//        test.add(new Item("item-7", 61));

        List<Item> res = test.findByValue(4);
        res.forEach(i -> System.out.println(i.name));


    }
}
