package java.scjp5.chapter8.anonymousclass;

public class AnonymousClass {

    Popcorn p = new Popcorn() {
        void pop() {
            System.out.println("Anonymous pop");
        }
    };

    Cookable c = new Cookable() {

        @Override
        public void cook() {
            System.out.println("Cookable cook");
        }
    };

    public static void main(String[] args) {
        AnonymousClass a = new AnonymousClass();
        a.p.pop();
    }

}

class Popcorn {
    void pop() {
        System.out.println("Food pop");
    }
}

interface Cookable {
    void cook();
}
