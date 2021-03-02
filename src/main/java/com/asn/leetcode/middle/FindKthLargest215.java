package com.asn.leetcode.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wangsen
 * @Date: 2021/3/2 12:40
 * @Description: 查找数组中第 K 大的元素
 **/
public class FindKthLargest215 {
    public static void main(String[] args) {

    }

    //方法一：排序
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //方法二：小顶堆
    public int findKthLargest2(int[] nums, int k) {


        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
