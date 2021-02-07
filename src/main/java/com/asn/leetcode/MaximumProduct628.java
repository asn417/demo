package com.asn.leetcode;

import java.util.Arrays;

/**
 * @Author: wangsen
 * @Date: 2021/1/20 15:16
 * @Description: 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 **/
public class MaximumProduct628 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProduct1(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3], nums[length - 1] * nums[0] * nums[1]);
    }

    //优化：其实只需要取出最大的三个数和最小的两个数即可，不必全体排序
    public static int maximumProduct1(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
