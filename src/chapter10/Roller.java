package chapter10;

import java.util.Random;

/**
 * Created by duongtq on 7/28/14.
 */
public class Roller {

    public static String rollIt() {
        Integer i = new Random().nextInt();
        return i.toString();
    }

    public static void rollIt(String s) {
        return;
    }

}
