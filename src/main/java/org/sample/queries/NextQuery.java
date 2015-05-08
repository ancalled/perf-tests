package org.sample.queries;

import org.sample.Operand;
import org.sample.Row;

import java.util.List;

public interface NextQuery {

    NextQuery and(String col, Operand.Operation op, Comparable val);

    NextQuery or(String col, Operand.Operation op, Comparable val);

    List<Row> get();
}
