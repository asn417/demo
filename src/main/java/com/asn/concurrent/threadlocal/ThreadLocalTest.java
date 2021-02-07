package com.asn.concurrent.threadlocal;

/**
 * @Author: wangsen
 * @Date: 2021/2/2 17:32
 * @Description: ThreadLocal是线程内部的共享变量，线程间是隔离的，一个线程只能看到自己内部的ThreadLocal变量。
 * <p>
 * 原理：每个Thread线程初始化的时候都会创建一个ThreadLocalMap对象，不同的线程在向ThreadLocal存值的时候，实际是将当前ThreadLocal对象作为key，以存的值作为value，
 * 存到ThreadLocalMap中的，以此实现线程隔离。
 **/
public class ThreadLocalTest {

    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        // 重写这个方法，可以修改“线程变量”的初始值，默认是null
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        // 创建一号线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 在一号线程中将ThreadLocal变量设置为1
                num.set(1);
                System.out.println("一号线程中ThreadLocal变量中保存的值为：" + num.get());
            }
        }).start();

        // 创建二号线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                num.set(2);
                System.out.println("二号线程中ThreadLocal变量中保存的值为：" + num.get());
            }
        }).start();

        //为了让一二号线程执行完毕，让主线程睡500ms
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("主线程中ThreadLocal变量中保存的值：" + num.get());
    }
}

