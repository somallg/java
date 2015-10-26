package java.scjp6.exams.practice.dump;

/**
 * Created by somallg on 5/2/14.
 */

interface Gadget {
}

class Watch {
    class Workings implements Gadget {
        Workings() {
            System.out.print("2 ");
        }

        void tick() {
            Workings in = new Workings();
        }

        {
            System.out.print("3 ");
        }
    }

    Watch() {
        System.out.print("1 ");
    }
}

public class Timer {
    public static void main(String[] args) {
        Watch w = new Watch();
        Watch.Workings ww = w.new Workings();
        ww.tick();
    }
}
