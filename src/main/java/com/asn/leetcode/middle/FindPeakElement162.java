package com.asn.leetcode.middle;

/**
 * @Author: wangsen
 * @Date: 2021/3/4 15:05
 * @Description: 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 示例 1：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 提示：
 * 1 <= nums.length <= 1000
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 **/
public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(findPeakElement1(nums));
    }

    //线性查找：O(N)
    public static int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    //二分查找：O(logN)
    public static int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
