package org.sample.test;

import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;



public class OverHeapTest {

    public static void main(String[] args) {
        ChronicleMap<Integer, String> chm = ChronicleMapBuilder
                .of(Integer.class, String.class)
                .create();

        chm.put(1, "test");
        chm.put(2, "test2");

        String res = chm.get(1);
        System.out.println("res = " + res);
    }
}
