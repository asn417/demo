package com.asn.algorithms;

import java.util.Arrays;

/**
 * @Author: wangsen
 * @Date: 2021/1/20 17:52
 * @Description: 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 示例：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 **/
public class FindMedianSortedArrays4 {
    public static void main(String[] args) {
        int[] nums1 = {}, nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    //思路一：合并到一个数组后排序，然后取中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combine = new int[nums1.length + nums2.length];
        int j = 0;
        for (int i : nums1) {
            combine[j++] = i;
        }
        for (int i : nums2) {
            combine[j++] = i;
        }
        Arrays.sort(combine);
        int mid = combine.length / 2;

        if (combine.length % 2 != 0)
            return combine[mid];
        else {
            return (combine[mid - 1] + combine[mid]) / 2.0;
        }
    }

    //思路二：
}
