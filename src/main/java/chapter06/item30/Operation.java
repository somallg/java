package java.chapter06.item30;

/**
 * Created by somallg on 8/23/14.
 */
public enum Operation {
    PLUS("+") {
        @Override
        double apply ( double x, double y){
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIME("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;
    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 2;
        double y = 3;
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }

        System.out.println(Operation.DIVIDE.ordinal());
    }
}
