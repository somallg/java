package java.scjp6.exams.practice.dump;

public class XMLMessage extends packageA.Message {
    String getText() {
        return "<msg>text</msg>";
    }

    public static void main(String[] args) {
        System.out.println(new XMLMessage().getText());
        int s = 6;
        s += 3 + ++s;
        System.out.println(Integer.toString(10));
    }

}
