package java.scjp6.exams.practice.dump;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Changeup {

    public static void main(String[] args) throws IOException {
        FileWriter fw = null;
        new Changeup().do2();
        Set s = new HashSet();
        doStuff(s);
        Map m = new HashMap();
        List l = new ArrayList();
        l.toArray();

    }

    void do2() throws FileNotFoundException {
    }

    static void doStuff(Set<Number> s) {

    }

}
