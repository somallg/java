package java.ocpjp7.exams.practice;

/**
 * Created by somallg on 5/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Integer i = 1000;
        Integer j = 1001;
        Integer k = ++i;
        System.out.println(k == j);
        new Main().new C().abc();
    }

    interface A {
        String name = "abc";
    }

    class B {
        String name;
    }

    class C extends B implements A {
        void abc() {
            System.out.println(((B)this).name);
        }
    }
}
