package java.scjp6.exams.practice.dump;

import java.io.File;

/**
 * Created by somallg on 5/4/14.
 */
class Bird {
    static {
        System.out.print("b1 ");
    }
}

class Raptor extends Bird {
    static {
        System.out.print("r1 ");
    }
}

public class Hawk extends Raptor {
    static {
        System.out.print("h1 ");
    }

    public static void main(String[] args) {
        System.out.println();
        Integer i = new Integer(1) + new Integer(2);
        switch (i) {
            case 3:
                System.out.println(3); break;
            default:
                System.out.println("other"); break;
        }
    }

    static void abc() { }
}
