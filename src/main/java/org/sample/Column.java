package org.sample;

public class Column {

    public enum Type {
        STRING, LONG, DOUBLE, BOOLEAN
    }

    final String name;
    final Type type;
    Comparable value;


    public Column(String name, Type type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Column(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public boolean checkType(Comparable obj) {
        if (type == Type.STRING) {
            return obj instanceof String;

        } else if (type == Type.LONG) {
            return obj instanceof Long;

        } else if (type == Type.DOUBLE) {
            return obj instanceof Double;

        } else if (type == Type.BOOLEAN) {
            return obj instanceof Boolean;
        }
        return true;
    }

    public Comparable getNullObject() {
        if (type == Type.STRING) {
            return "";

        } else if (type == Type.LONG) {
            return 0;

        } else if (type == Type.DOUBLE) {
            return 0.0;

        } else if (type == Type.BOOLEAN) {
            return false;
        }
        return "";
    }

}
