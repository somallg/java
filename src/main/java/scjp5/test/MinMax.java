package java.scjp5.test;

public class MinMax<N extends Number> {

    private N min, max;

    public N getMin() {
        return min;
    }

    public N getMax() {
        return max;
    }

    public void add(N added) {
        if (min == null || added.doubleValue() < min.doubleValue())
            min = added;
    }
}
