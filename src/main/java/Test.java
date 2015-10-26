package java;

/**
 * Created by duongtq on 7/31/14.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello Lala");
        System.out.println(new Test().getMessage());
        
        double value = -9.0;
        System.out.println( Math.sqrt(value));


        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        };

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        };

        r.run();
        r1.run();
        r.run();

    }
    
    static final void m1() {}

    public String getMessage() {
        return "Hello Lala";
    }
}
