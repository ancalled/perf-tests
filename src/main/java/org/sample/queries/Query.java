package org.sample.queries;

import org.sample.Operand;
import org.sample.Operand.Operation;
import org.sample.Row;
import org.sample.SubscrCallback;
import org.sample.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.sample.queries.Query.LogicOperator.AND;
import static org.sample.queries.Query.LogicOperator.OR;

public class Query implements FirstQuery, NextQuery {

    enum LogicOperator {
        AND, OR
    }

    public final Table table;
    public final boolean subscribed;
    public final SubscrCallback callback;
    public final List<Operand> operands = new ArrayList<>();
    public final List<LogicOperator> logicOps = new ArrayList<>();


    public Query(Table table) {
        this(table, null);
    }

    public Query(Table table, SubscrCallback callback) {
        this.table = table;
        this.subscribed = callback != null;
        this.callback = callback;
    }

    public NextQuery where(String field, Operation op, Comparable val) {
        operands.add(new Operand(field, op, val));
        return this;
    }

    public NextQuery and(String field, Operation op, Comparable val) {
        operands.add(new Operand(field, op, val));
        logicOps.add(AND);
        return this;
    }

    public NextQuery or(String field, Operation op, Comparable val) {
        operands.add(new Operand(field, op, val));
        logicOps.add(OR);
        return this;
    }

    public boolean match(Row row) {
        for (int i = 0; i < operands.size(); i++) {
            Operand op = operands.get(i);
            int idx = table.getColumnIndex(op.field);
            if (idx < 0) return false;
            Comparable val = row.columns.get(idx);
            boolean matches = op.matches(val);

            LogicOperator logOp;
            if (i == 0) {
                if (!logicOps.isEmpty()) {
                    logOp = logicOps.get(0);
                } else {
                    logOp = AND;
                }
            } else {
                logOp = logicOps.get(i - 1);
            }

            if (logOp == AND && !matches) return false;
            if (logOp == OR && matches) return true;
            if (logOp == OR && i == operands.size() - 1) return false;
        }

        return true;
    }


    public List<Row> get() {
        List<Row> row = table.select(this::match)
                .collect(Collectors.toList());
        if (subscribed) {
            table.dataBase.addSubscription(this);
        }
        return row;
    }

    @Override
    public String toString() {
        return "Query{ " +
                "table=" + table.name +
                ", subscribed=" + subscribed +
                ", callback=" + callback +
                ", operands=" + operands +
                ", logicOps=" + logicOps +
                '}';
    }
}
