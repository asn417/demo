package com.asn.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wangsen
 * @Date: 2021/2/4 12:28
 * @Description:
 **/
public class FindMaxAverage643 {
    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(arr, k));
    }

    //超时(想复杂了)
    public static double findMaxAverage(int[] nums, int k) {
        int sum = Integer.MIN_VALUE;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                int count = count(queue);
                sum = sum > count ? sum : count;
                queue.poll();
                queue.offer(num);
            }
        }
        int count = count(queue);
        sum = sum > count ? sum : count;
        return (double) sum / k;
    }

    public static int count(Queue<Integer> queue) {
        int sum = 0;
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }

    public static double findMaxAverage1(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
            } else {
                max = Math.max(max, sum);
                sum = sum + nums[i] - nums[i - k];
            }
        }
        max = Math.max(max, sum);
        return (double) max / k;
    }
}
