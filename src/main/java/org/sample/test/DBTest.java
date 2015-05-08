package org.sample.test;

import org.sample.DBExecption;
import org.sample.DataBase;

import static org.sample.Column.Type.DOUBLE;
import static org.sample.Column.Type.STRING;
import static org.sample.Operand.Operation.LESS;

public class DBTest {

    public static void main(String[] args) throws DBExecption, InterruptedException {
        DataBase db = new DataBase();
        db.createTable("market-data")
                .addColumn("symbol", STRING)
                .addColumn("bid", DOUBLE)
                .addColumn("ask", DOUBLE)
                .addColumn("open", DOUBLE)
                .addColumn("high", DOUBLE)
                .addColumn("low", DOUBLE)
                .addColumn("close", DOUBLE)
                .addColumn("last", DOUBLE);

//        long applId = db.insert("market-data", "AAPL");
//        long fbId = db.insert("market-data", "FB");
//
//        db.update("market-data", applId, "bid", 145.3);
//        db.update("market-data", applId, "bid", 145.4);
//        db.update("market-data", applId, "bid", 145.1);
//        db.update("market-data", fbId, "last", 200.14);
//
//
//        db.select("market-data")
//                .where("symbol", EQUALS, "AAPL")
//                .and("ask", LESS, 145.4)
//                .get()
//                .forEach(System.out::println);

        for (int i = 0; i < 100; i++) {
            db.insert("market-data", "symb" + i);
        }

//        db.select("market-data")
//                .where("bid", LESS, 1030)
////                .or("bid", GREATER, 1050)
//                .get()
//                .forEach(System.out::println);

        db.subscribe("market-data", System.out::println)
                .where("bid", LESS, 1030.5)
                .get()
        ;
//                .forEach(System.out::println);

        for (int i = 0; i < 100; i++) {
            db.update("market-data", i + 2, "bid", i * Math.PI);
        }

        Thread.sleep(10000);
    }
}
