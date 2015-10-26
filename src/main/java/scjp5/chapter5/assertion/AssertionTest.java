package java.scjp5.chapter5.assertion;

import java.io.FileNotFoundException;

public class AssertionTest {

    public static void main(String[] args) {
        assert 1 < 2 : "1 < 2";
    }

    static void noReturn() throws FileNotFoundException {
    }

}
