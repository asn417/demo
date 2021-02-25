package com.asn.algoritms.leetcode.huawei.middle;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 字符个数统计
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String line = sc.nextLine();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < line.length(); i++) {
                set.add(line.substring(i,i+1));
            }
            System.out.println(set.size());
        }
    }
}
