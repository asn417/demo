package com.asn.algoritms.leetcode.huawei.difficult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 查找兄弟单词
 */
public class HJ27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.next();
            }
            String word = sc.next();
            int k = sc.nextInt();

            List<String> list = new ArrayList<>();
            for (String s : arr) {
                if (!s.equals(word) && s.length()==word.length() && isValid(s,word)){
                    list.add(s);
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            if (list.size()>=k){
                System.out.println(list.get(k-1));
            }
        }
    }
    public static boolean isValid(String s,String word){
        char[] arr1 = s.toCharArray();
        char[] arr2 = word.toCharArray();

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[arr1[i]-'a']++;
            arr[arr2[i]-'a']--;
        }
        for (int i : arr) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
