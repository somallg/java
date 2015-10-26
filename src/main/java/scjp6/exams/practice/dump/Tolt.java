package java.scjp6.exams.practice.dump;

/**
 * Created by somallg on 5/4/14.
 */
public class Tolt {
    public static void checkIt(int a) {
        if (a == 1) throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        for (int x = 0; x < 2; ++x)
            try {
                System.out.print("t ");
                checkIt(x);
                System.out.print("t2 ");
            } catch (Exception e) {
                System.out.print("e ");
            } finally {
                System.out.print("f ");
            }
    }
}
