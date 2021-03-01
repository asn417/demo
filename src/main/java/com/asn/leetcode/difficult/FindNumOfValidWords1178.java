package com.asn.leetcode.difficult;

import java.util.*;

/**
 * @Author: wangsen
 * @Date: 2021/2/26 15:45
 * @Description: 猜字谜
 **/
public class FindNumOfValidWords1178 {
    public static void main(String[] args) {
        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        List<Integer> li = findNumOfValidWords1(words, puzzles);
        li.stream().forEach(x -> {
            System.out.println(x);
        });
    }

    //暴力法：超时
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            String head = puzzle.substring(0, 1);
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                int index;
                if (word.contains(head)) {
                    for (index = 0; index < word.length(); index++) {
                        if (!puzzle.contains(word.substring(index, index + 1))) {
                            break;
                        }
                    }
                    if (index == word.length()) {
                        count++;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    //官方答案
    public static List<Integer> findNumOfValidWords1(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            //因为puzzle的长度限制为7，所以这里可以过滤掉不同字母数量大于7的word
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;
            // 枚举子集方法一
            // for (int choose = 0; choose < (1 << 6); ++choose) {
            //     int mask = 0;
            //     for (int i = 0; i < 6; ++i) {
            //         if ((choose & (1 << i)) != 0) {
            //             mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
            //         }
            //     }
            //     mask |= (1 << (puzzle.charAt(0) - 'a'));
            //     if (frequency.containsKey(mask)) {
            //         total += frequency.get(mask);
            //     }
            // }

            // 枚举子集方法二
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            ans.add(total);
        }
        return ans;
    }
}
