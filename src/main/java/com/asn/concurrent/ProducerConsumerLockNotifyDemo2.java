package com.asn.concurrent;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 9:53
 * @Description:
 **/
public class ProducerConsumerLockNotifyDemo2 {
    public static void main(String[] args) {
        ProductBuffer buffer = new ProductBuffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new ConsumerWithSub(buffer)).start();
    }
}
