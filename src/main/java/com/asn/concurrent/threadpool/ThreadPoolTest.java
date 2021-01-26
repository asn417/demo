package com.asn.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 13:16
 * @Description: 线程池
 * 参数解释：
 * corePoolSize：corePoolSize>=0,池中要保留的线程数，即使它们处于空闲状态，除非设置了 {allowCoreThreadTimeOut(true)}，这个方法会将keepAliveTime参数应用到核心线程中来管理空闲超时线程。
 * maximumPoolSize：maximumPoolSize>0 && maximumPoolSize>=corePoolSize,池中最大线程数（最大线程数 = 核心线程数 + 非核心线程数）
 * keepAliveTime：>=0,允许非核心线程空闲的最大时间（当任务队列满了之后，如果还有新的任务提交，就会创建非核心线程。非核心线程空闲超时后就会销毁）
 * unit：keepAliveTime的单位
 * workQueue：保存待执行的任务的队列（当核心线程都在执行，那么新来的任务就会放到任务队列中等待执行。只保存由 {execute} 方法提交的 {Runnable} 任务）。
 * 任务队列有三种，有界队列（只能存指定数量个任务）、无界队列（可以存无限数量的任务）、阻塞队列（任务是有序进入队列的，线程安全）。
 * 线程池工作流程：
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        //workQueue的大小最好设置的足够大，否则可能会抛异常 RejectedExecutionException
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(10));
        executor.allowCoreThreadTimeOut(true);
        Future<?> future = executor.submit(() -> {
            System.out.println("11111");
            return "xxx";
        });

        try {
            String str = (String) future.get();
            System.out.println("str:" + str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
