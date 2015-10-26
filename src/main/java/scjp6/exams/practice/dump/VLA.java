package java.scjp6.exams.practice.dump;

import java.util.Arrays;
import java.util.Comparator;

public class VLA implements Comparator<VLA> {

    int i;

    public static void main(String[] args) {
        VLA[] vla = {new VLA(40), new VLA(200), new VLA(60)};
        int i = Arrays.binarySearch(vla, new VLA(60), vla[0]);
        System.out.println(i);
    }

    @Override
    public int compare(VLA a, VLA b) {
        return a.i - b.i;
    }

    VLA(int i) {
        this.i = i;
    }

}
