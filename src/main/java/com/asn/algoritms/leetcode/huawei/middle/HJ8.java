package com.asn.algoritms.leetcode.huawei.middle;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 */
public class HJ8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
            for(int i=0;i<num;i++){
                String str = sc.next();
                String str1 = sc.next();
                map.put(Integer.valueOf(str),map.getOrDefault(Integer.valueOf(str),0)+Integer.valueOf(str1));
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }
}
