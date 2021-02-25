package com.asn.algoritms.leetcode.huawei.simple;

import java.util.Scanner;

/**
 * 计算整数的二进制表示中的1的个数
 */
public class HJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            int count = 0;
            while (num!=0){
                if ((num & 1) == 1){
                    count++;
                }
                num=num>>1;
            }
        }
    }
}
