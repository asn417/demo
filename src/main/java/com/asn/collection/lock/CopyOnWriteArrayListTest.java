package com.asn.collection.lock;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: wangsen
 * @Date: 2021/1/28 14:47
 * @Description:
 **/
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<Integer>();
        list.add(1);
    }
}
