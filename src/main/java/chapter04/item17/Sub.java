package java.chapter04.item17;

/**
 * Created by duongtq on 8/8/14.
 */
public class Sub extends Super {

    Sub() {
        System.out.println(this.getClass());
        overrideMe();
    }

    @Override
    public void overrideMe() {
        System.out.println("Sub");
    }

}
