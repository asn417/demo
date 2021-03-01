package com.asn.algoritms.leetcode.simple;

/**
 * 单调数列
 */
public class IsMonotonic896 {
    public static void main(String[] args) {
        int[] A={6,5,3,3};
        System.out.println(isMonotonic(A));
    }
    public static boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len<2)
            return true;
        int a = 1,b = 1;
        for (int i = 1; i < len; i++) {
            if (A[i]>=A[i-1]){
                a++;
            }
            if (A[i]<=A[i-1]){
                b++;
            }
        }
        return a==len||b==len;
    }
}
