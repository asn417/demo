package com.asn.leetcode.simple;

/**
 * @Author: wangsen
 * @Date: 2021/3/4 14:26
 * @Description: 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 **/
public class Search704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;//避免超出int范围
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
