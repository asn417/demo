package com.asn.leetcode.simple;

import java.util.ArrayList;

class MyHashSet705 {
    public static void main(String[] args) {
        MyHashSet705 set = new MyHashSet705();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }

    ArrayList<Integer>[] arr;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet705() {
        size = 10;
        arr = new ArrayList[size];
    }

    public void add(int key) {
        int index = key % size;
        ArrayList<Integer> old = arr[index];
        if (old == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(key);
            arr[index] = list;
        } else {
            boolean containKey = false;
            for (int num : old) {
                if (num == key) {
                    containKey = true;
                    break;
                }
            }
            if (!containKey) {
                old.add(key);
            }
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int index = key % size;
            ArrayList<Integer> oldList = arr[index];
            ArrayList<Integer> newList = new ArrayList<>();
            for (int num : oldList) {
                if (num != key) {
                    newList.add(num);
                }
            }
            arr[index] = newList.size() == 0 ? null : newList;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key % size;
        ArrayList<Integer> old = arr[index];
        if (old == null) {
            return false;
        } else {
            boolean containKey = false;
            for (int num : old) {
                if (num == key) {
                    containKey = true;
                    break;
                }
            }
            return containKey;
        }
    }
}