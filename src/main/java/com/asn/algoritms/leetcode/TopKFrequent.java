package com.asn.algoritms.leetcode;

import java.util.*;

/**
 * @Author: wangsen
 * @Date: 2021/2/2 12:04
 * @Description: https://blog.csdn.net/u014600626/article/details/103554112
 **/
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 3, 3, 2, 2, 4};
        int k = 2;
        topKFrequent1(nums, k).forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println();
        topKFrequent2(nums, k).forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println();
        topKFrequent3(nums, k).forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println();

    }

    //全排序法
    public static List<Integer> topKFrequent1(int[] nums, int k) {
        // 统计元素的频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 对元素按照频率进行降序排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 取出前k个元素
        int count = 0;
        List<Integer> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            ret.add(entry.getKey());
            ++count;
            if (count >= k) {
                break;
            }
        }
        return ret;
    }

    //最小堆法
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        // 统计元素的频率
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {//a是新的数，b是旧的数
                return map.get(b) - map.get(a);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.remove());
        }
        return ret;
    }

    //桶排序
    public static List<Integer> topKFrequent3(int[] nums, int k) {
        // 统计元素的频次
        Map<Integer, Integer> int2FreqMap = new HashMap<>(16);
        for (int num : nums) {
            int2FreqMap.put(num, int2FreqMap.getOrDefault(num, 0) + 1);
        }

        // 桶排序
        List<Integer>[] bucket = new List[nums.length + 1];//创建nums+1个桶
        for (Integer key : int2FreqMap.keySet()) {
            int freq = int2FreqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // 逆序（频次由高到低）取出元素
        List<Integer> ret = new ArrayList<>();
        for (int i = nums.length; i >= 0 && ret.size() < k; --i) {
            if (bucket[i] != null) {
                for (Integer key : bucket[i]) {
                    if (ret.size() < k) {
                        ret.add(key);
                    } else {
                        return ret;
                    }
                }
            }
        }
        return ret;
    }


}
