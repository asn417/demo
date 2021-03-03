package com.asn.leetcode.middle;

/**
 * @Author: wangsen
 * @Date: 2021/3/3 10:54
 * @Description: 比特位计数
 **/
public class CountBits338 {
    public static void main(String[] args) {

    }

    public int[] countBits1(int num) {
        int[] arr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0, n = i;
            while (n > 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n = n >> 1;
            }
            arr[i] = count;
        }
        return arr;
    }

    //一个数除了偶数就是奇数，偶数的最低位为0，奇数的最低位为1。奇数和偶数是交替出现的。奇数-1必然是偶数，偶数-1必然是奇数。
    //如果用f(n)表示n的二进制数中1的个数，那么当n是奇数时，则f(n) = f(n-1) + 1;当n是偶数时，f(n) = f(n/2);
    //此外，f(0)=0;这样根据递推公式就能遍历一遍得到结果。
    public int[] countBits2(int num) {
        int[] arr = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {//用&计算判断奇偶性
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = arr[i >> 1];//>>1无符号右移1位替换除2操作
            }
        }
        return arr;
    }
}
