package java.scjp5.chapter6.tokenizing;

public class Tokenizing {

    public static void main(String[] args) {
        String a = "abc,def";
        String[] b = a.split(",");
        for (String s : b) {
            System.out.println(s);
        }

    }

}