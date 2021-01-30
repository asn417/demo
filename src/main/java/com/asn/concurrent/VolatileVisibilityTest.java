package com.asn.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 测试volatile的可见性
 * 当线程共享对象ThreadData中的num没被volatile修饰时，num被一个线程修改后并不会通知其他线程（这里是main线程），所以会一直循环
 */
public class VolatileVisibilityTest {
    public static void main(String[] args) {
        ThreadData data = new ThreadData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 线程开始工作");
            try {
                TimeUnit.SECONDS.sleep(3);//先睡3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.changeTo20();//3秒过后再修改值
            System.out.println("num has changed to "+data.num);
        }).start();

        //main线程工作中的num如果为0，就一直循环
        while (data.num == 0){

        }
        System.out.println(Thread.currentThread().getName()+" 线程运行结束");
    }
}
class ThreadData{
    volatile int num = 0;
    public void changeTo20(){
        num = 20;
    }
}