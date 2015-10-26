package java.scjp5.chapter5.exceptionhandling;

public class ExceptionHandling {

    interface I {

    }

    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
