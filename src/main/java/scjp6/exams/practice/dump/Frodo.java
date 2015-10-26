package java.scjp6.exams.practice.dump;

/**
 * Created by somallg on 5/4/14.
 */
public class Frodo extends Hobbit {
    public static void main(String[] args) {
        Short myGold = 7;
        System.out.println(new Frodo().countGold(7 , 7));
        System.out.println(Integer.valueOf("123"));
    }

    void abc() {
        countGold(1, 1);
    }

}

class Hobbit {
    int countGold(short x, int y) {
        return x + y;
    }

    long countGold(long s, int y) {
        return s * 100;
    }
}
