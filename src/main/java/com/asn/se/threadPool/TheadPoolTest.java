package com.asn.se.threadPool;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * @Author: wangsen
 * @Date: 2020/11/1 16:55
 * @Description:
 **/
public class TheadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        long start = System.currentTimeMillis();
        Future<String> a = executorService.submit(() -> {
            Thread.sleep(5000);
            return "a thread";
        });
        //get是个阻塞方法，因此应该把所有线程的get方法统一放到最后一个线程的后面，否则就成串行了。
        System.out.println("get=" + a.get());
        //下面的这个线程会等上面的get返回值之后再提交
        Future<String> b = executorService.submit(() -> {
            Thread.sleep(5000);
            return "b thread";
        });

        System.out.println("get=" + b.get());
        long end = System.currentTimeMillis();
        System.out.println("=================耗时：" + (end - start));
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "hh";
    }
}