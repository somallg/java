package java.scjp6.exams.practice.dump;

public class TestComperable {

    public <T extends Comparable> T findLarger(T x, T y) {
        if (x.compareTo(y) > 0)
            return x;
        else
            return y;
    }

    public static void main(String[] args) {
        TestComperable tc = new TestComperable();
        Object x = tc.findLarger(123, "456");
        int i = tc.findLarger(1, new Integer(12));
        tc.findLarger(new Double(1), new Double(2));
    }

}
