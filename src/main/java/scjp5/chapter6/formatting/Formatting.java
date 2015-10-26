package java.scjp5.chapter6.formatting;

import java.util.regex.Pattern;

public class Formatting {

    public static void main(String[] args) {
        String a = new String("abc");
        String b = new String("abc");
        System.out.println(a == b);
        System.out.println(a.equals(b));
//		System.out.printf("%d", 12.3);
        Pattern p = Pattern.compile("\\d*");
        System.out.println(p.pattern());
        System.out.println((short) 343);
    }

}
