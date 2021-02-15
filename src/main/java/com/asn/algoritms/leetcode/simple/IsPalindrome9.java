package com.asn.algoritms.leetcode.simple;

/**
 * 回文数
 */
public class IsPalindrome9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1000000001));
    }
    public static boolean isPalindrome(int x) {
        if(x<0){return false;}
        if(x==0){return true;}

        long i=x,j=0;//这里存在翻转后超出int范围的情况，因此使用long类型。但完全可以只翻转一半来确定是否是回文数。
        while(i>0){
            j = j*10 + i % 10;
            i/=10;
        }
        return j==x;
    }
}
