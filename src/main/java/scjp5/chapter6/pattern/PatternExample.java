package java.scjp5.chapter6.pattern;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d*");
        Matcher m = p.matcher("ab34ef");
        boolean b = false;

        while (b = m.find()) {
            System.out.println(m.start() + ": " + m.group());
        }
        System.out.printf("%s", new Long(100));
        System.out.println(File.separator);

        StringBuffer sb = new StringBuffer("..fedcba");
        sb.delete(3, 6);
        System.out.println(sb); // ..fba
        sb.insert(3, "az");
        System.out.println(sb); // ..fazba
        int x = 4;
        if (sb.length() > 6)
            x = sb.indexOf("b"); // 5
        sb.delete((x - 3), (x - 2)); // sb.delete(2, 3)
        System.out.println(sb); // ..azba

    }

}
