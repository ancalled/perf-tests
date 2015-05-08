package org.sample.test;

import org.openjdk.jmh.annotations.*;
import org.sample.DBExecption;
import org.sample.Operand;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@OutputTimeUnit(TimeUnit.MICROSECONDS)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class OpMatchPerfTest {


    @Param({"EQUALS", "LESS", "GREATER"})
    private String operation;

    @Param({"double:435.1,435.2", "string:test,test", "long:100500,100500"})
    private String opParam;


    private Operand operand;

    private Comparable colVal;

    public OpMatchPerfTest() {
    }

    public OpMatchPerfTest(String operation, String opParam) {
        this.operation = operation;
        this.opParam = opParam;
    }

    @Setup(Level.Trial)
    public void init() throws DBExecption {
        Operand.Operation op = Operand.Operation.valueOf(operation);
        Comparable[] vals = parseVals(opParam);
        Comparable opVal = vals[0];
        colVal = vals[1];
        operand = new Operand("field", op, opVal);
    }

    public static Comparable[] parseVals(String param) {
        String[] splitted = param.split(":");
        String type = splitted[0];
        String[] vals = splitted[1].split(",");

        return new Comparable[] {parseVal(type, vals[0]), parseVal(type, vals[1])};
    }

    public static Comparable parseVal(String type, String strVal) {
        if ("double".equals(type)) {
            return Double.valueOf(strVal);
        } else if ("long".equals(type)) {
            return Long.valueOf(strVal);
        } else if ("int".equals(type)) {
            return Integer.valueOf(strVal);
        } else if ("boolean".equals(type)) {
            return Boolean
                    .valueOf(strVal);
        }

        return strVal;
    }


    @Benchmark
    public boolean match() throws DBExecption {
        return operand.matches(colVal);
    }

//    @Benchmark
//    public List<Row> select() throws DBExecption {
//        return query.get();
//    }

    public static void main(String[] args) throws DBExecption {
//        @Param({"EQUALS", "LESS", "GREATER"})
//        @Param({"double:435.1", "string:test", "long:100500"})
//        @Param({"double:435.1", "string:test1", "long:100500"})

//        final OpMatchPerfTest test = new OpMatchPerfTest("EQUALS", "double:435.1", "double:435.1");
        final OpMatchPerfTest test = new OpMatchPerfTest("LESS", "double:435.1,435.2");
        test.init();
        System.out.println(test.match());
    }
}
