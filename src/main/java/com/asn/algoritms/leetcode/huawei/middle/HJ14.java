package com.asn.algoritms.leetcode.huawei.middle;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 字符串排序
 *
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            TreeMap<String,Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                map.put(s,map.getOrDefault(s,0)+1);
            }
            for (Map.Entry<String, Integer> entry :
                    map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                for (int i = 0; i < value; i++) {
                    System.out.println(key);
                }
            }
        }
    }
}
