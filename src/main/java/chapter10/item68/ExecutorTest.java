package java.chapter10.item68;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by somallg on 8/27/14.
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i)
                    System.out.println(Thread.currentThread().getName()+ " " + i);
            }
        });

        for (int i = 0; i < 10; ++i)
            System.out.println(Thread.currentThread().getName() + " " + i);
        executor.shutdown();
    }
}
