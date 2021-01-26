package com.asn.leetcode.huawei.simple;

import java.util.Scanner;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 17:42
 * @Description: 翻转字符串
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述:
 * 输入一行，为一个只包含小写字母的字符串。
 * <p>
 * 输出描述:
 * 输出该字符串反转后的字符串。
 **/
public class HJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            System.out.println(reverse(sc.nextLine()));
        }
    }

    public static String reverse(String str) {
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }
}
