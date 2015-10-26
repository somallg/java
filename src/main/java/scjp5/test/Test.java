package java.scjp5.test;

public class Test implements Runnable {

    public static void main(String[] a) throws Exception {
        boolean assertOn = true;
        assert (assertOn) : assertOn;
        if (assertOn) {
            System.out.println("assert is on");
        }

        System.out.println("ABC");
        new Test().finalize();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i)
            System.out.println("run " + i);
    }

    @Override
    public void finalize() {
        System.out.println("finialize");
    }

}

//-5
