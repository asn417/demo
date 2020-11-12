package com.example.demo;

/**
 * @Author: wangsen
 * @Date: 2020/11/5 9:36
 * @Description:
 **/
public class A {
    static int i = 100;
    public static void main(String[] args) {
        System.out.println("A类的主线程启动，args="+args);
        Thread thread = new Thread(() -> {
            while (i>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i--);
            }
        });
        thread.start();
    }
}
