package java.scjp6.exams.practice.dump;

public class Thread1 {

    class R implements Runnable {
        @Override
        public void run() {
            System.out.println("R");
        }
    }

    public static void main(String[] args) {
        Runnable r = new Thread1().new R();
        Thread t = new Thread(r) {
            @Override
            public void run() {
                System.out.println("Go");
            }
        };
        t.start();
    }

}
