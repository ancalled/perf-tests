package org.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Table {

    public final DataBase dataBase;
    public final String name;
    public List<Column> schema = new ArrayList<>();
    private Map<Long, Row> rows = new HashMap<>();
    private AtomicLong atomicId = new AtomicLong(1);

    public Table(DataBase dataBase, String name) {
        this.dataBase = dataBase;
        this.name = name;
    }

    public Table addColumn(String name, Column.Type type) {
        schema.add(new Column(name, type));
        return this;
    }

    public Row insert(Event event, Comparable... values) throws DBExecption {
        checkSchema(values);
        final long id = atomicId.incrementAndGet();
        final List<Comparable> valList = new ArrayList<>();
        for (int i = 0; i < schema.size(); i++) {
            if (i < values.length) {
                valList.add(values[i]);
            } else {
                valList.add(schema.get(i).getNullObject());
            }
        }

        final Row row = new Row(this, id, valList);
        event.row = row;
        rows.put(id, row);
        return row;
    }


    public void update(Event event, long id, String column, Comparable value) throws DBExecption {
        Row row = rows.get(id);
        if (row == null)
            throw new DBExecption("Row was not found: key: " + id + " at table " + name);

        int idx = getColumnIndex(column);
        if (idx < 0) throw new DBExecption("Column was not found: " + column + "!");
        row.columns.set(idx, value);
        event.row = row;
    }

    public void delete(Event event, long id) throws DBExecption {
        event.row = rows.remove(id);
    }


    public Stream<Row> select(Predicate<Row> condition) {
        return rows.values()
                .stream()
                .filter(condition);
    }

    public List<Row> selectAsList(Predicate<Row> condition) {
        return select(condition).collect(Collectors.toList());
    }


    private void checkSchema(Comparable... values) throws DBExecption {
        if (values.length > schema.size()) throw new DBExecption("Too many values!");

        for (int i = 0; i < values.length; i++) {
            Column col = schema.get(i);
            Comparable val = values[i];
            if (!col.checkType(val))
                throw new DBExecption("Wrong type on " + col.name + " with value: '" + val + "!");
        }
    }


    public int getColumnIndex(String col) {
        for (int i = 0; i < schema.size(); i++) {
            Column c = schema.get(i);
            if (c.name.equals(col)) return i;
        }

        return -1;
    }


}
