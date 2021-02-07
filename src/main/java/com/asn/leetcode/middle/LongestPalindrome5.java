package com.asn.leetcode.middle;

/**
 * @Author: wangsen
 * @Date: 2021/2/1 17:06
 * @Description: 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 **/
public class LongestPalindrome5 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        String temp = "";
        for (int i = 0; i < len; i++) {
            temp = help(s, i, i);
            if (res.length() < temp.length()) {
                res = temp;
            }
            temp = help(s, i, i + 1);
            if (res.length() < temp.length()) {
                res = temp;
            }
            System.out.println(res);
        }
        return res;
    }

    public static String help(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.substring(low, low + 1).equals(s.substring(high, high + 1))) {
                low--;
                high++;
            } else {
                break;
            }
        }
        if (low < 0) {
            low = 0;
            high = high - 1;
        }
        if (high >= s.length()) {
            high = s.length() - 1;
            low = low + 1;
        }
        return s.substring(low, high + 1);
    }
}
