package org.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Condition {

    List<Operand> predicates;

    public Condition(Operand... predicates) {
        this.predicates = Arrays.asList(predicates);
    }

    public Condition(List<Operand> predicates) {
        this.predicates = predicates;
    }


    public boolean matches(List<Column> row) {
        for (Column c : row) {
            for (Operand p : predicates) {
                if (c.name.equals(p.field)) {
                    if (!p.matches(c)) return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return predicates.stream().map(p -> p.field + "\t" + p.op + "\t" + p.value)
                .collect(Collectors.joining(", "));
    }
}
