package java.scjp6.exams.practice.dump;

import java.util.LinkedList;
import java.util.List;

public class Test extends Super {

    static String s = "Test";

    public static void main(String[] args) {
        System.out.println(new Test().s);
        String[] a = {};
        System.out.println(a[0]);
        List<Integer> l = new LinkedList<Integer>();
    }
}

class Super {
    String s = "Super";
}
