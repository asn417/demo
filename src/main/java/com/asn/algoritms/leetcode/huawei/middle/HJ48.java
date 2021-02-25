package com.asn.algoritms.leetcode.huawei.middle;

import java.util.Scanner;

public class HJ48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nodes = Integer.parseInt(sc.next());
            //System.out.println("nodes:"+nodes);
            int headData = Integer.parseInt(sc.next());
            //System.out.println("headData:"+headData);
            Node head = new Node(headData);
            for (int i = 0; i < nodes - 1; i++) {
                int to = Integer.parseInt(sc.next());
                int from = Integer.parseInt(sc.next());
                update(head, from, to);
                //print(head);
            }

            int delData = Integer.parseInt(sc.next());
            Node del = del(head, delData);
            while (del != null){
                System.out.print(del.data+" ");
                del = del.next;
            }
        }
    }

    private static Node del(Node head, int delData) {
        if (head.data == delData)
            return head.next;
        Node temp = head;
        Node pre = head;
        while (temp != null){
            if (temp.data == delData){
                pre.next = temp.next;
                break;
            }else {
                pre = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    private static void update(Node head, int from, int to) {
        Node temp = head;
        while (temp != null){
            if (temp.data == from){
                Node oldNext = temp.next;
                temp.next = new Node(to);
                temp.next.next = oldNext;
                break;
            }else {
                temp = temp.next;
            }
        }
    }

    public static void print(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
class Node{
    Node next;
    int data;
    public Node(int data){
        this.data = data;
        next = null;
    }
}