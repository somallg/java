package java.scjp6.exams.practice.dump;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SuperCalc {
    protected static int multiply(int a, int b) {
        return a * b;
    }
}

public class SubCalc extends SuperCalc {
    public static int multiply(int a, int b) {
        return 0;
    }

    public static void main(String[] args) {
        SuperCalc sc = new SubCalc();
        System.out.println(((SubCalc) sc).multiply(2, 3));
        List<String> l = new ArrayList<String>();
        l.add("A");
        l.add("A");
        l.add("A");
//		String[] s = (String[]) l.toArray();
        Iterator i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
