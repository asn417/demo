package com.asn.algoritms.leetcode.huawei.simple;

import java.util.Scanner;

public class HJ62 {
    public static void main(String[] args) {
        System.out.println(count(100));
    }
    public static int count(int num){
        int count = 0;
        for (int i = 0; i <= 14; i++) {
            for (int j = 0; j <= 25; j++) {
                if (i*7+j*4 == 100){
                    System.out.println(i+" "+j+" "+(100 - i -j));
                    count+=(i+j);
                }
            }
        }
        return count;
    }
}
