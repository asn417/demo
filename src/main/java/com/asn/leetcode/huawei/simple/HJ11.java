package com.asn.leetcode.huawei.simple;

import java.util.Scanner;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 16:51
 * @Description: 数字颠倒
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 **/
public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            System.out.println(reverse(i));
        }
    }

    public static String reverse(int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        sb.reverse();
        return sb.toString();
    }
}
