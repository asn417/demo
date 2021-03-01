package com.asn.leetcode.simple;

/**
 * @Author: wangsen
 * @Date: 2021/3/1 10:06
 * @Description: 移动零：将一个数组中的0元素移动到数组末尾，非零元素间的相对顺序保持不变。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 注意：必须再原数组上操作，不允许使用额外数组
 **/
public class MoveZeroes283 {
    public static void main(String[] args) {

    }

    //思路：要求把0元素移动到末尾，反过来说就是将非0元素移动到前面。那么就可以遍历数组，分别用两个变量记录遇到的第一个0和第一个非0，互换位置即可。
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    //优化：方法一在遇到中间有大量连续0的时候，就完全变成O(N^2)复杂度了。如[1,0,0,0,0,0,0,0,1,2]
    public static void moveZeroes1(int[] nums) {
        int notZero = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                if (notZero == -1) {
                    notZero = i + 1;
                }
                while (notZero < nums.length) {
                    if (nums[notZero] != 0) {
                        nums[i] = nums[notZero];
                        nums[notZero++] = 0;
                        break;
                    }
                    notZero++;
                }
            }
        }
    }
}
