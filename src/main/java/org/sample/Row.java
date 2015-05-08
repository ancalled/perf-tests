package org.sample;

import java.util.List;

public class Row {

    public final List<Comparable> columns;
    public final long id;
    public final Table table;

    public Row(Table table, long id, List<Comparable> values) {
        this.table = table;
        this.id = id;
        this.columns = values;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("id: ").append(id);
        for (int i = 0; i < table.schema.size(); i++) {
            Column col = table.schema.get(i);
            Object val = columns.get(i);
            buf.append(", ").append(col.name).append(": ").append(val);
        }
        return buf.toString();
    }
}
