package com.asn.algoritms.leetcode.huawei.middle;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 提取不重复的数数字
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 9876673
 * 输出
 * 37689
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String num = sc.next();
            StringBuilder sb = new StringBuilder();
            HashSet<String> set = new HashSet<>();
            for (int i = num.length()-1; i >= 0; i--) {
                if (!set.contains(num.substring(i,i+1))){
                    sb.append(num.substring(i,i+1));
                    set.add(num.substring(i,i+1));
                }
            }
            System.out.println(sb);
        }
    }
}
