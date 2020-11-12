package com.asn.se.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: wangsen
 * @Date: 2020/11/4 21:13
 * @Description: 等待子线程都运行结束后再继续执行主线程
 **/
public class MultiThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(3);


        /*Future<String> future1 = ThreadUtil.execAsync(
                (Callable) () -> {
                    try {
                        Thread.sleep(100);
                        return "a";
                    }finally {
                        countDownLatch.countDown();
                    }
                }
        );
        Future<String> future2 = ThreadUtil.execAsync(
                (Callable) () -> {
                    try {
                        Thread.sleep(200);
                        return "b";
                    }finally {
                        countDownLatch.countDown();
                    }
                }
        );
        Future<String> future3 = ThreadUtil.execAsync(
                (Callable) () -> {
                    try {
                        Thread.sleep(100);
                        return "c";
                    }finally {
                        countDownLatch.countDown();
                    }
                }
        );*/
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("thread1 sleep over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(2000);
                System.out.println("thread2 sleep over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });
        Thread thread3 = new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println("thread3 sleep over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        /*System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());*/
        countDownLatch.await();
       /* String s1 = future1.get();
        String s2 = future2.get();
        String s3 = future3.get();
        System.out.println(s1+s2+s3);*/
        System.out.println("main thread run over!");
    }
}
