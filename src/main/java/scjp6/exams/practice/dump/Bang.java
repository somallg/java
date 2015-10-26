package java.scjp6.exams.practice.dump;


public class Bang {

    public static void main(String[] args) {
        // Locale l = new Locale(null);
        // Bang b = new Bang();
        // A a = b.new A();
        // B b2 = (B) a;
        String s = new String("abc");
        Object o = new Object();
        String s2 = (String) o;
        System.out.println(s2);
    }

    class A {
    }

    class B extends A {
    }

}
