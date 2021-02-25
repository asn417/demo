package com.asn.algoritms.leetcode.huawei.difficult;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 密码验证
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String pw = sc.next();
            System.out.println(isValid(pw));
        }
    }

    private static String isValid(String pw) {
        if (pw.length()<9)
            return "NG";
        Set<Integer> set = new HashSet<>();
        char[] arr = pw.toCharArray();
        for (char c : arr) {
            if (Character.isLowerCase(c)) {
                set.add(0);
            } else if (Character.isUpperCase(c)) {
                set.add(1);
            } else if (Character.isDigit(c)) {
                set.add(2);
            } else {
                set.add(3);
            }
        }
        if (set.size()<3)
            return "NG";

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < pw.length()-3; i++) {
            String substring = pw.substring(i, i + 3);
            if (set1.contains(substring))
                return "NG";
            else
                set1.add(substring);
        }
        return "OK";
    }
}
