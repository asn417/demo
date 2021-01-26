package com.asn.concurrent;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 9:53
 * @Description: 生产者消费者，利用wait和notify实现。一个生产者和三个消费者，生产者生产产品，消费者消费产品，仓库最大容纳20个产品，仓库满了则生产者阻塞，
 * 仓库为空则消费者阻塞，三个消费者可以并发消费。
 **/
public class ProducerConsumerLockNotifyDemo1 {
    public static void main(String[] args) {
        ProductBuffer buffer = new ProductBuffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
