package java.chapter08;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by duongtq on 03/09/2014.
 */
public class ThreadDeadLock {
    private static ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
        exec.submit(new RenderPageTask());
    }

    public static class RenderPageTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Future<String> header, footer;

            header = exec.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    return "header";
                }
            });

            footer = exec.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    return "footer";
                }
            });

            // Will deadlock -- task waiting for result of sub-task
            return header.get() + " body " + footer.get();
        }
    }
}
