package java.scjp5.chapter9.threadsinteraction;

public class ThreadsInteraction extends Thread {

    ThreadB b;

    public ThreadsInteraction(ThreadB b) {
        this.b = b;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperties().toString());
        C:

        A:
        for (int i = 0; i < 10; ++i)
            B:for (int j = 0; j < 10; ++j) {
                System.out.println(i + " " + j);
                break C;
            }

        ThreadB b = new ThreadB();
        new ThreadsInteraction(b).start();
        new ThreadsInteraction(b).start();
        new ThreadsInteraction(b).start();
        b.start();
    }

    public void run() {
        synchronized (b) {
            try {
                System.out.println("Waiting for b to complete");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Total is " + b.total);
        }
    }

}

class ThreadB extends Thread {
    int total;

    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        synchronized (this) {
            for (int i = 0; i < 5; ++i) {
                total += i;
            }
            notifyAll();
            System.out.println("notifyAll");
        }
    }
}

class A {
}

class B extends A {
    int i;
}
