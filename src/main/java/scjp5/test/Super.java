package java.scjp5.test;

public class Super {
    private int a;

    protected Super(int a) {
        this.a = a;
    }
}

class Sub extends Super {
    public Sub(int a) {
        super(a);
    }

    public Sub() {
        super(5);
    }
}
