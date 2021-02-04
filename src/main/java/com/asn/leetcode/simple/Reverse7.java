package com.asn.leetcode.simple;

/**
 * @Author: wangsen
 * @Date: 2021/2/4 15:18
 * @Description: 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * 提示：
 * -231 <= x <= 231 - 1
 **/
public class Reverse7 {
    public static void main(String[] args) {
        System.out.println(reverse3(123));
    }

    //解法一：先转成string再反转
    public static int reverse1(int x) {
        StringBuilder reverse;
        long res = 0;
        String str = String.valueOf(x);
        if (x < 0) {
            str = str.substring(1);
            reverse = new StringBuilder(str).reverse();
            res = -Long.parseLong(reverse.toString());
        } else {
            reverse = new StringBuilder(str).reverse();
            res = Long.parseLong(reverse.toString());
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }

    //解法二：知道长度后，每一位乘上位数后相加
    public static int reverse2(int x) {
        long res = 0;
        String str = String.valueOf(x).replace("-", "");
        for (int i = 0; i < str.length(); i++) {
            res += Integer.valueOf(str.substring(i, i + 1)) * Math.pow(10, i);
        }
        if (x < 0) {
            res = -res;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        return (int) res;
    }

    //解法三：
    public static int reverse3(int x) {
        int ans = 0;
        while (x != 0) {
            /*if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }*/
            ans = ans * 10 + x % 10;
            x = x / 10;
            System.out.println("ans=" + ans + ",x=" + x);
        }
        return ans;
    }
}
