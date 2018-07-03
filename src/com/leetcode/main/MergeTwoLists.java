package com.leetcode.main;

import com.leetcode.entity.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author gongshiyun
 * @date: 2018/5/4 23:07
 */
public class MergeTwoLists {
    public static void main(String[] arg) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(6);

        l1.setNext(l2);
        l2.setNext(l3);
        l4.setNext(l5);
        l5.setNext(l6);
        ListNode result = mergeTwoListsByRecursive(l1, l4);
        System.out.print(result.val);
        while (result.getNext() != null) {
            System.out.print(" -> ");
            result = result.getNext();
            System.out.print(result.getVal());
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode curNode = headNode;
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.next = l1;
        p2.next = l2;
        int v1;
        int v2;
        while (p1.next != null && p2.next != null) {
            v1 = p1.next.val;
            v2 = p2.next.val;
            if (v1 < v2) {
                curNode.next = new ListNode(v1);
                p1 = p1.next;
            } else {
                curNode.next = new ListNode(v2);
                p2 = p2.next;
            }
            curNode = curNode.next;
        }

        if (p1.next != null) {
            curNode.next = p1.next;
        } else if (p2.next != null) {
            curNode.next = p2.next;
        }

        return headNode.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode headNode = new ListNode(0);
        ListNode curNode = headNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = l1 == null ? l2 : l1;

        return headNode.next;
    }

    public static ListNode mergeTwoListsByRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursive(l2.next, l1);
            return l2;
        }
    }
}
