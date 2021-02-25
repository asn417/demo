package com.asn.algoritms.leetcode.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wangsen
 * @Date: 2021/2/1 14:28
 * @Description: 求滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 **/
public class MaxSlidingWindow239 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7, 1, 2, -10};
        int step = 3;
        int[] res = maxSlidingWindow(arr, step);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //依次遍历求出每个窗口的最大值，超时
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            int[] temp = tempWindowMax1(nums, i, i + k - 1);
            res[i] = temp[0];
        }
        return res;
    }

    public static int[] tempWindowMax1(int[] nums, int from, int to) {
        int[] valueIndex = new int[2];
        int tempMax = Integer.MIN_VALUE;
        int tempMaxIndex = from;
        for (int j = from; j <= to; j++) {
            if (tempMax < nums[j]) {
                tempMax = nums[j];
                tempMaxIndex = j;
            }
        }
        valueIndex[0] = tempMax;
        valueIndex[1] = tempMaxIndex;
        return valueIndex;
    }

    //保留上一个窗口的最大值和下标，对于下一个窗口来说，如果上一个窗口的最大值在本窗口内，那么只需要比较上个窗口的最大值和本窗口的最后一个值即可。还是超时。
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int tempMax = Integer.MIN_VALUE;
        int tempMaxIndex = -1;
        for (int i = 0; i < res.length; i++) {
            int[] temp = tempWindowMax2(nums, i, i + k - 1, tempMax, tempMaxIndex);
            res[i] = temp[0];
        }
        return res;
    }

    public static int[] tempWindowMax2(int[] nums, int from, int to, int lastMax, int lastMaxIndex) {
        int[] valueIndex = new int[2];
        if (lastMaxIndex < from) {
            int tempMax = nums[from];
            int tempMaxIndex = from;
            for (int j = from; j <= to; j++) {
                if (tempMax < nums[j]) {
                    tempMax = nums[j];
                    tempMaxIndex = j;
                }
            }
            valueIndex[0] = tempMax;
            valueIndex[1] = tempMaxIndex;
        } else {
            if (lastMax < nums[to]) {
                valueIndex[0] = nums[to];
                valueIndex[1] = to;
            } else {
                valueIndex[0] = lastMax;
                valueIndex[1] = lastMaxIndex;
            }
        }
        return valueIndex;
    }

    //双端递减队列

    /**
     * 1.想将我们第一个窗口的所有值存入单调双端队列中，单调队列里面的值为单调递减的。如果发现队尾元素小于要加入的元素，则将队尾元素出队，直到队尾元素大于新元素时，再让新元素入队，
     * 目的就是维护一个单调递减的队列。
     * 2.我们将第一个窗口的所有值，按照单调队列的规则入队之后，因为队列为单调递减，所以队头元素必为当前窗口的最大值，则将队头元素添加到数组中。
     * 3.移动窗口，判断当前窗口前的元素是否和队头元素相等，如果相等则出队。
     * 4.继续按照规则进行入队，维护单调递减队列。
     * 5.每次将队头元素存到返回数组里。
     * 5.返回数组
     **/
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //有点坑，题目里都说了数组不为空，且 k > 0。但是看了一下，测试用例里面还是有nums = [], k = 0，所以只好加上这个判断
        if (nums == null || nums.length < k || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //在尾部添加元素，并保证左边元素都比尾部大
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //在头部移除元素
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            //输出结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
