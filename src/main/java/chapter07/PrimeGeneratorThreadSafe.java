package java.chapter07;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by somallg on 9/2/14.
 */
public class PrimeGeneratorThreadSafe {
    private final BlockingQueue<BigInteger> queue;

    public PrimeGeneratorThreadSafe(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;

            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
                System.out.println(i);
                if (++i > 10) break;
            }
        } catch (InterruptedException e) {
            /* Allow thread to exit */
        }

    }

    public void cancel() {
        Thread.currentThread().interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " shutdown hook 1");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " shutdown hook 2");
            }
        });

        System.out.println(Thread.currentThread().getName() + " main is about to shutdown");

        ExecutorService exec = Executors.newFixedThreadPool(10);

        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " hehe");
            }
        });

        exec.shutdown();
        exec.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("After await");

    }
}
