package com.asn.algoritms.leetcode.huawei.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 简单密码破解
 * 规则：小写字母转换成手机按键上对应的数字，大写字母则取下一位对应的小写字母，其他则不做转换
 */
public class HJ21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            System.out.println(help(str));
        }
    }

    private static String help(String str) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('a',2);
        map.put('b',2);
        map.put('c',2);
        map.put('d',3);
        map.put('e',3);
        map.put('f',3);
        map.put('g',4);
        map.put('h',4);
        map.put('i',4);
        map.put('j',5);
        map.put('k',5);
        map.put('l',5);
        map.put('m',6);
        map.put('n',6);
        map.put('o',6);
        map.put('p',7);
        map.put('q',7);
        map.put('r',7);
        map.put('s',7);
        map.put('t',8);
        map.put('u',8);
        map.put('v',8);
        map.put('w',9);
        map.put('x',9);
        map.put('y',9);
        map.put('z',9);
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (Character.isUpperCase(c)){
                sb.append(Character.toLowerCase((char)(c+1==91?65:c+1)));
            }else if (Character.isLowerCase(c)){
                sb.append(map.get(c));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
