package com.asn.concurrent.volatileTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * volatile的原子性测试（volatile不满足原子性）
 *  原子性就是一个操作是完整的，不可分割的。比较典型的就是i++操作，这个操作在底层字节码层面会被分成3个步骤，先将i读取到线程工作内存，然后
 *  做+1操作，最后同步回主内存。
 */
public class VolatileAtomicityTest {
    public static void main(String[] args) {
        ThreadData data = new ThreadData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    data.num++;
                }
            },i+"线程").start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+",num="+data.num);
    }
}
