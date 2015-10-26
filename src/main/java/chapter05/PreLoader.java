package java.chapter05;

import model.ProductInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by somallg on 9/2/14.
 */
public class PreLoader {
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            return loadProductInfo();
        }
    });

    private ProductInfo loadProductInfo() {
        ProductInfo p = new ProductInfo();
        p.setName("Lala");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return p;
    }

    private final Thread thread = new Thread(future);

    public void start() {
        //thread.start();
        future.run();
    }

    public ProductInfo get() throws InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            PreLoader p = new PreLoader();
            p.start();
            System.out.println(Thread.currentThread().getName());
            System.out.println(p.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
