package java.chapter02.item07;

/**
 * Created by DuongTQ on 8/6/2014.
 */

// Finalizer Guardian idiom
public class Foo {
    // Sole purpose of this object is to finalize outer Foo object
    private final Object finalizerGuardian = new Object() {
        @Override
        protected void finalize() throws Throwable {
            // Finalize outer Foo obejct
        }
    };

    // Remaining of class

    public static void main(String[] args) {
        Object o = null;

        System.out.printf(String.valueOf(o instanceof Object));
    }
}
