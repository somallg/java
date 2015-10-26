package java.scjp5.chapter3.accessmodifier;

public class AccessModifier {
    public static void main(String[] args) {
        System.out.println(Foo.i);
        System.out.println(System.getProperties().toString());
    }
}


class Foo {
    static int i = 10;    // Change i to private, public
}
