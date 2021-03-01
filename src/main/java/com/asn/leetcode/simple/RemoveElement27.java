package com.asn.leetcode.simple;

/**
 * @Author: wangsen
 * @Date: 2021/3/1 10:48
 * @Description: 移除元素
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 **/
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
    }

    //思路：双指针，left记录值为val的下标，right记录值为非val的下标，互换位置。直到left>=right为止。
    public static int removeElement(int[] nums, int val) {
        int count = 0, left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                left++;
                count++;
            } else {
                if (nums[right] == val) {
                    right--;
                } else {
                    nums[left++] = nums[right--];
                    count++;
                }
            }
        }
        return count;
    }
}
