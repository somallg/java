package java.scjp6.exams.practice.exercises;

public class Section2C {

    public static void main(String[] args) {
        try {
            A a = new A();
            B b = (B) a;            // Class cast exception
            int[] i = null;
            System.out.println(i[0]);   // null pointer exception;
            i = new int[1];
            //System.out.println(i[1]);   // ArrayIndexOutOfBounds exception;
            Section2C s = new Section2C();
            //s.doA();    // Stack over flow error
            assert (false); // assertion error
            Integer.parseInt("abc"); // NFE
        } catch (StackOverflowError ae) {
            ae.printStackTrace();
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        } catch (ClassCastException ce) {
            ce.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ae) {
            ae.printStackTrace();
        } catch (AssertionError ae) {
            ae.printStackTrace();
        } catch (NumberFormatException ae) {
            ae.printStackTrace();
        }
    }

    void doA() {
        doA();
    }
}

class A {
}

class B extends A {
}
