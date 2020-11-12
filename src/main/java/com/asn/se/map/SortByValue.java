package com.asn.se.map;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangsen
 * @Date: 2020/11/2 18:26
 * @Description:
 **/
public class SortByValue {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(10);
        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO)!=0);
    }
    public static List<String> sortByValue(Map<String, Integer> map) {
        int size = map.size();
        //通过map.entrySet()将map转换为"1.B.1.e=78"形式的list集合
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(size);
        list.addAll(map.entrySet());
        List<String> keys = list.stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed())
                .map(Map.Entry<String, Integer>::getKey)
                .collect(Collectors.toList());
        return keys;
    }

    public static void sort(Map<String, Map<String,Object>> map){

        Map<String,Map<String,Object>> treemap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

    }

}
