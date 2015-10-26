package java.scjp5.chapter3.overloading;

public class BoxAndWiden {
    static void go(Number o) {
        Byte b2 = (Byte) o;
        System.out.println(b2);
    }

    // ok - it's a Byte object
    public static void main(String[] args) {
        byte b = 5;
        go(b);
        // can this byte turn into an Object ?
    }
}
