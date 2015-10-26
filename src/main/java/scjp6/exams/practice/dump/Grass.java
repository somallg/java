package java.scjp6.exams.practice.dump;

/**
 * Created by somallg on 5/4/14.
 */

interface Plant {
    int greenness = 7;
    void grow();
}
public class Grass implements Plant {

    //static int greenness = 5;
    int greenness = 5;

    public static void main(String[] args) {
        int greenness = 2;
        new Grass().grow();
    }
    @Override
    public void grow() {
        System.out.println(++greenness);
    }
}
