package org.sample;

import org.sample.queries.FirstQuery;
import org.sample.queries.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DataBase {

    private final Map<String, Table> tables = new HashMap<>();

//    public ExecutorService notifier = Executors.newSingleThreadExecutor();
    public final LocalExecutor localExecutor = new LocalExecutor();
    private final AtomicLong eventId = new AtomicLong(0);
//    private final List<Query> subscriptions = new CopyOnWriteArrayList<>();

    public DataBase() {
//        localExecutor.start();
    }

    public Table createTable(String name) throws DBExecption {
        Table t = new Table(this, name);
        tables.put(t.name, t);
        return t;
    }

    public Row insert(String table, Comparable... values) throws DBExecption {
        Table tbl = tables.get(table);
        if (tbl == null)
            throw new DBExecption("Table " + table + " not found!");

        final Event event = createEvent();
        Row row = tbl.insert(event, values);
        notify(event);
        return row;
    }

    public void update(String table, long id, String column, Comparable value) throws DBExecption {
        Table tbl = tables.get(table);
        if (tbl == null)
            throw new DBExecption("Table " + table + " not found!");
        final Event event = createEvent();
        tbl.update(event, id, column, value);
        notify(event);
    }

    public void delete(String table, long id) throws DBExecption {
        Table tbl = tables.get(table);
        if (tbl == null)
            throw new DBExecption("Table " + table + " not found!");
        final Event event = createEvent();
        tbl.delete(event, id);
        notify(event);
    }


    public Stream<Row> select(String table, Predicate<Row> condition) throws DBExecption {
        Table tbl = tables.get(table);
        if (tbl == null)
            throw new DBExecption("Table " + table + " not found!");
        return tbl.select(condition);
    }

    public FirstQuery select(String table) throws DBExecption {
        Table tbl = tables.get(table);
        if (tbl == null)
            throw new DBExecption("Table " + table + " not found!");

        return new Query(tbl);
    }

    public FirstQuery subscribe(String table, SubscrCallback subscrCallback) throws DBExecption {
        Table tbl = tables.get(table);
        if (tbl == null)
            throw new DBExecption("Table " + table + " not found!");

        return new Query(tbl, subscrCallback);
    }

    private void notify(final Event ev) {
        localExecutor.newEvent(ev);
        /*notifier.execute(() ->
//                subscriptions.stream()
//                        .filter(s -> s.match(ev.row))
//                        .forEach(s -> s.callback.onUpdate(ev.row))
        {
                for (Query s: subscriptions) {
                    if (s.match(ev.row)) {
                        s.callback.onUpdate(ev.row);
                    }
                }
        }
        );*/
    }

    private Event createEvent() {
        return new Event(eventId.incrementAndGet());
    }

    public void addSubscription(Query q) {
//        subscriptions.add(q);
        localExecutor.addSubscription(q);
    }

    public static class LocalExecutor extends Thread  {

        private final BlockingQueue<Event> queue = new ArrayBlockingQueue<>(200);

//        private final List<Query> subscriptions = new CopyOnWriteArrayList<>();
        private final List<Query> subscriptions = new ArrayList<>();

        public LocalExecutor() {
            super("LocalExecutor");
            setDaemon(true);
        }

        public void addSubscription(Query q) {
            subscriptions.add(q);
        }

        public void newEvent(Event e) {
            try {
                queue.put(e);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                Event ev = null;
                try {
                    ev = queue.take();
                } catch (InterruptedException e1) {
                    Thread.currentThread().interrupt();
                }
                if (ev != null) {
                    for (Query s: subscriptions) {
                        if (s.match(ev.row)) {
                            s.callback.onUpdate(ev.row);
                        }
                    }
                }
            }

        }
    }

}
