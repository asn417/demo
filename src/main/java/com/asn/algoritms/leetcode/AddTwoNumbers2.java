package com.asn.algoritms.leetcode;

/**
 * @Author: wangsen
 * @Date: 2021/1/20 15:45
 * @Description: 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 **/
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        l11.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        l21.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode point = head;
        int val = 0;
        while (l1 != null || l2 != null) {
            ListNode temp = new ListNode();
            point.next = temp;
            point = temp;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (val > 9) {
                temp.val = val - 10;
                val = 1;
            } else {
                temp.val = val;
                val = 0;
            }
        }
        if (val > 0) {
            ListNode temp = new ListNode(val);
            point.next = temp;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
