package java.chapter04.item17;

/**
 * Created by duongtq on 8/8/14.
 */
public class Super {

    public Super() {
        System.out.println(this.getClass());
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("Supper");
    }
}
