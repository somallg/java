package java.scjp5.chapter8.regularinnerclass;

public class RegularInnerClass {

    private int x = 7;

    public static void main(String[] args) {
        RegularInnerClass r = new RegularInnerClass();
        Inner i = r.new Inner();
        i.printX();
        Inner i2 = new RegularInnerClass().new Inner();
        i2.printX();
    }

    Inner makeInner() {
        Inner i = new Inner();
        i.printX();
        return i;
    }

    class Inner {
        void printX() {
            System.out.println("x = " + x);
            System.out.println("Inner class ref " + this);
            System.out.println("Outer class ref  " + RegularInnerClass.this);
        }
    }

}
