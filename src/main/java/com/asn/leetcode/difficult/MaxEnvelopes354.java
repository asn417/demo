package com.asn.leetcode.difficult;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangsen
 * @Date: 2021/3/4 9:42
 * @Description: 俄罗斯套娃
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 **/
public class MaxEnvelopes354 {
    public static void main(String[] args) {

    }

    //思路：按行遍历一遍二维数组，将arr[n][0]作为key，arr[n][1]作为value存入map。对map根据key和value二次排序，且要对key和value分别去重。
    public static int maxEnvelopes1(int[][] envelopes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < envelopes.length; i++) {
            int key = envelopes[i][0];
            int value = envelopes[i][1];
            if (map.containsKey(key)) {
                map.put(key, Math.max(map.get(key), value));
            }

        }
        return 0;
    }
}
