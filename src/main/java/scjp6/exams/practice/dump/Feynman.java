package java.scjp6.exams.practice.dump;

import java.io.IOException;

class Physicist {
    void think() throws IOException {
    }
}

public class Feynman extends Physicist {

    public static void main(String[] args) {
        new Feynman().think();
    }

    void think() throws NullPointerException {
    }

}
