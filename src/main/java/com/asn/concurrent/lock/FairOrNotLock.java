package com.asn.concurrent.lock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wangsen
 * @Date: 2020/9/16 9:16
 * @Description: 公平锁与非公平锁
 **/
public class FairOrNotLock {
    public static void main(String[] args) {
        ReentrantLock unfair = new ReentrantLock();
        ReentrantLock unfair1 = new ReentrantLock(false);
        ReentrantLock fair = new ReentrantLock(true);
        String s1 = "ab"+"cd";
        String s2 = "abcd";
        System.out.println("s1 == s2:"+(s1==s2));

        String s3 = "ab";
        String s4 = "cd";
        String s5 = s3 + s4;
        System.out.println("s2 == s5:"+(s2==s5));

        HashMap<String,String> map = new HashMap<>();
        map.put("a","s");

        System.out.println(hash(1));
        System.out.println(hash(2));
        System.out.println(hash("A"));
        System.out.println(hash("b"));

    }
    public static int hash(Object o){
        int h;
        return (o == null) ? 0 : (h = o.hashCode()) ^ (h >>> 16);
    }

}
