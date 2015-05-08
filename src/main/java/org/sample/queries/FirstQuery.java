package org.sample.queries;

import org.sample.Operand;
import org.sample.Row;

import java.util.List;

public interface FirstQuery {
    NextQuery where(String col, Operand.Operation op, Comparable val);
    List<Row> get();
}
