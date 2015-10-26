package java.scjp5.chapter9.threadsexample;

public class ThreadsExample {

    public static void main(String[] args) {
        Runnable r = new MyRunnalbe();
        Thread one = new Thread(r, "one");
        Thread two = new Thread(r, "two");
        Thread three = new Thread(r, "three");
        one.start();
        try {
            one.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        two.start();
        three.start();
    }
}

class MyRunnalbe implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
            Thread.yield();
        }
    }
}
