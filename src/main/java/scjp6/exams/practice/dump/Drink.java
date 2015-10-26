package java.scjp6.exams.practice.dump;

import java.util.TreeSet;

public class Drink implements Comparable<Drink> {
    public String name;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Drink o) {
        return 0;
    }

    public static void main(String[] args) {
        Drink d1 = new Drink();
        Drink d2 = new Drink();
        d1.name = "Coffe";
        d2.name = "Tea";

        TreeSet s = new TreeSet();
        s.add(d1);
        s.add(d2);

        for (Object o : s) {
            System.out.println(o);
        }

        String s2 = "<msg>text</msg>";
    }

}
