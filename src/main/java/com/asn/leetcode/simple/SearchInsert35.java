package com.asn.leetcode.simple;

/**
 * @Author: wangsen
 * @Date: 2021/3/4 14:47
 * @Description: 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 **/
public class SearchInsert35 {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left + (right - left) / 2] == target) {
                return left + (right - left) / 2;
            }
            if (nums[left + (right - left) / 2] < target) {
                left = left + (right - left) / 2 + 1;
            } else {
                right = left + (right - left) / 2 - 1;
            }
        }
        return left;
    }
}
