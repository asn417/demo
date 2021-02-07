package com.asn.leetcode.middle;

/**
 * @Author: wangsen
 * @Date: 2021/2/2 13:11
 * @Description: 替换后的最长重复子串
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 10^4。
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * <p>
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 **/
public class CharacterReplacement424 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABBB", 2));
    }

    /**
     * 双指针窗口滑动法。使用两个指针分别作为窗口的left、right，不断右移动right指针（扩大窗口），将窗口中的字符数作为一个中间结果（替换后的最长重复字符），
     * 当窗口大小 - 窗口中出现次数最多的字符数即是需要替换的字母数。如果需要替换的字母数超过了k，则说明需要缩小窗口（右移left）。
     **/
    public static int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
