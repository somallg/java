package java.scjp5.chapter8.methodlocalinner;

public class MethodLocalInner {

    private String x = "ABC";

    void doABC() {

        final int t = 10;

        class Inner {
            public void seeOuter() {
                System.out.println("x outer is " + x);
                System.out.println("t local is " + t);
            }
        }

        Inner i = new Inner();
        i.seeOuter();
    }

    public static void main(String[] args) {
        MethodLocalInner m = new MethodLocalInner();
        m.doABC();
    }

}