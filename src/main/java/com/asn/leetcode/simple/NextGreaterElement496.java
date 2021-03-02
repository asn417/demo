package com.asn.leetcode.simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * 下一个更大元素（单调栈）
 */
public class NextGreaterElement496 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};
        int[] res = nextGreaterElement(nums1, nums2);
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //遍历nums2
        for (int num : nums2) {
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (num > peek) {
                    map.put(stack.pop(), num);
                } else {
                    break;
                }
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
