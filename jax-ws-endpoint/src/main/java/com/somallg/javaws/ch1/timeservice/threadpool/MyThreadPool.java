package com.somallg.javaws.ch1.timeservice.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by somallg on 5/12/14.
 */
public class MyThreadPool extends ThreadPoolExecutor {
    private static final int pool_size = 10;
    private boolean is_paused;
    private ReentrantLock pause_lock = new ReentrantLock();
    private Condition unpaused = pause_lock.newCondition();

    public MyThreadPool() {
        super(pool_size,
                pool_size, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(pool_size));
    }

    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        pause_lock.lock();
        try {
            while (is_paused) unpaused.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pause_lock.unlock();
        }
    }

    public void pause() {
        pause_lock.lock();
        try {
            is_paused = true;
        } finally {
            pause_lock.unlock();
        }
    }

    public void resume() {
        pause_lock.lock();
        try {
            is_paused = false;
            unpaused.signalAll();
        } finally {
            pause_lock.unlock();
        }
    }
}
