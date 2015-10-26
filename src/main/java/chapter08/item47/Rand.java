package java.chapter08.item47;

import java.util.Random;

/**
 * Created by duongtq on 8/26/14.
 */
public class Rand {

    private static final Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n/2)
                low++;
        }

        System.out.println(low);
    }
}
