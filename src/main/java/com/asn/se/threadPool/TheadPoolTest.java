package com.asn.se.threadPool;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author: wangsen
 * @Date: 2020/11/1 16:55
 * @Description:
 **/
public class TheadPoolTest {

    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        MyThread myThread = new MyThread();
        executorService.execute(new MyThread());
        executorService.submit(new Thread(myThread));
        executorService.execute(myThread);

        executorService1.execute(new MyThread2());
        executorService.submit(new MyThread3());
        executorService.shutdown();*/


        BigDecimal bigDecimal = BigDecimal.ZERO;
        BigDecimal bigDecimal1 = new BigDecimal(BigInteger.valueOf(0), BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal1==bigDecimal);
        System.out.println(bigDecimal1.compareTo(bigDecimal));
        System.out.println(new BigDecimal(""));
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