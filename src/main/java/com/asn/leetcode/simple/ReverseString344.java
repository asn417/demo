package com.asn.leetcode.simple;

/**
 * @Author: wangsen
 * @Date: 2021/3/4 13:53
 * @Description: 反转字符串
 * 要求：不适用额外空间
 **/
public class ReverseString344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        if (s.length < 1) {
            return;
        }
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
