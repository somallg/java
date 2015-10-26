package java.scjp6.exams.practice.dump;

import java.util.Locale;

class Engine {
    public class Piston {
        int count = 0;

        void abc() {
        }
    }
}

public class Auto {

    public static void main(String[] args) {
        Locale l = Locale.getDefault();
        show(1L, 1);
    }

    static void show(int i, int j) {
        System.out.println("int int");
    }

    static void show(long i, int j) {
        System.out.println("long int");
    }
}
