package org.sample;

public class Operand {

    public enum Operation {
        EQUALS, NOTEQ, LESS, GREATER
    }

    public Operand(String field, Operation op, Comparable value) {
        this.field = field;
        this.op = op;
        this.value = value;
    }

    public final String field;
    public final Operation op;
    public final Comparable value;


    @SuppressWarnings("unchecked")
    public boolean matches(Column c) {
        if (c.name.equals(field)) {
            switch (op) {
                case EQUALS:
                    return c.value.equals(value);
                case NOTEQ:
                    return !c.value.equals(value);
                case LESS:
                    return c.value.compareTo(value) > 0;
                case GREATER:
                    return c.value.compareTo(value) < 0;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean matches(Comparable val) {

        switch (op) {
            case EQUALS:
                return val.equals(value);
            case NOTEQ:
                return !val.equals(value);
                case LESS:
                      return value.compareTo(val) > 0;
                case GREATER:
                    return value.compareTo(val) < 0;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Operand{" +
                "field='" + field + '\'' +
                ", op=" + op +
                ", value=" + value +
                '}';
    }
}
