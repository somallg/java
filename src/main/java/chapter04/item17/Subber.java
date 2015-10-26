package java.chapter04.item17;

/**
 * Created by somallg on 8/8/14.
 */
public class Subber extends Sub {

    @Override
    public void overrideMe() {
        System.out.println("Subber");
    }

    public static void main(String[] args) {
        new Subber().overrideMe();
        new Super();
    }
}
