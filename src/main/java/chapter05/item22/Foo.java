package java.chapter05.item22;

/**
 * Created by duongtq on 8/10/14.
 */
public class Foo {

    int i;
    static int j;

    class Bar {
        void methodA() {
            i = 10;
            j = 12;
            System.out.println(i + j);
        }
    }

    public static void main(String[] args) {

    }

}
