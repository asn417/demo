package com.asn.se.thread;

import java.util.concurrent.*;

/**
 * @Author: wangsen
 * @Date: 2020/11/4 21:13
 * @Description: 等待子线程都运行结束后再继续执行主线程
 **/
public class MultiThreadTest1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(3);



        FutureTask<String> task1 = new FutureTask<>(() -> {
            Thread.sleep(3000);
            int i=0;
            try {
                //int j = 10/i;
                System.out.println("sssssssss");
            }catch (Exception e) {
                System.out.println(32342423);
                //countDownLatch.countDown();
                throw e;
            }
            //countDownLatch.countDown();
            return Thread.currentThread().getName();
        });
        FutureTask<String> task2 = new FutureTask<>(() -> {
            Thread.sleep(3000);
            //countDownLatch.countDown();
            System.out.println("aaaaaa");
            return Thread.currentThread().getName();
        });
        FutureTask<String> task3 = new FutureTask<>(() -> {
            Thread.sleep(2000);
            //countDownLatch.countDown();
            System.out.println("ffffffff");
            return Thread.currentThread().getName();
        });
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        /*while (true){
            Thread.sleep(1000);
            System.out.println(task1.isDone());
            if (task1.isDone() && task2.isDone() && task3.isDone()){
                System.out.println(task1.get()+" ,"+task2.get()+" ,"+task3.get());
                executorService.shutdown();
                break;
            }
        }*/

        //countDownLatch.await();
        //executorService.shutdown();
        System.out.println(task1.get());
        System.out.println(task2.get());
        System.out.println(task3.get());
        System.out.println("main thread run over!");
    }
}
