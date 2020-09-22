package com.example.demo.utils;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author: wangsen
 * @Date: 2020/9/15 10:43
 * @Description:
 **/
public class ListUtil {
    public static <T>List<T> distinct1(List<T> sourceList){
        List<T> result = Lists.newArrayList();
        for(int i=0;i<sourceList.size();i++){
            if(!result.contains(sourceList.get(i)))
                result.add(sourceList.get(i));
        }
        return result;
    }
    public static <T> void distinct2(List<T> sourceList){
        Set<T> set = new HashSet<>();
        for(int i=0;i<sourceList.size();i++){
            if(!set.contains(sourceList.get(i))) {
                set.add(sourceList.get(i));
            }else {
                sourceList.remove(i);
                i--;
            }
        }
    }
    public static <T> void distinct3(List<T> sourceList){
        Iterator<T> iterator = sourceList.iterator();
        Set<T> set = new HashSet<>();
        while (iterator.hasNext()){
            T next = iterator.next();
            if(!set.contains(next)) {
                set.add(next);
            }else {
                iterator.remove();
            }
        }
    }
}
