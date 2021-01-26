package com.asn.concurrent.producerconsumer;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 15:23
 * @Description:
 **/
public interface ProductBufferInterface {
    void put(Product product);

    Product get();

    String getWithSubThread();
}
