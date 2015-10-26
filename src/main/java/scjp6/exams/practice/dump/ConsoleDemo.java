package java.scjp6.exams.practice.dump;

import java.io.Console;

public class ConsoleDemo {

    public static void main(String[] args) {
        Console c = System.console();
        char[] pw;
        pw = c.readPassword("%s", "password: ");
        for (char ch : pw) c.format("%c ", ch);
        while (true) {
            //String name = c.readLine("%s", "input:? ");
            String name = c.readLine();
            c.format("output: %s \n", name);
        }
    }

}
