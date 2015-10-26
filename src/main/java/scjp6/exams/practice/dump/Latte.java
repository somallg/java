package java.scjp6.exams.practice.dump;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by somallg on 5/4/14.
 */
public class Latte {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("aba");
        Matcher m = p.matcher("abababa");
        while (m.find()) {
             System.out.println(m.group()); }
    }
}
