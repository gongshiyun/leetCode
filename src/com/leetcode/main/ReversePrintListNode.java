package com.leetcode.main;

import com.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 * @author gongshiyun
 * @date: 2018/6/26 1:27
 */
public class ReversePrintListNode {
    private static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        l5.setNext(l6);

        //printListFromTailToHead(l1);
        //ArrayList<Integer> arr = getListFromTailToHead(l1);
        ArrayList<Integer> arr = printListFromTailToHeadByStack(l1);
        if (arr != null) {
            for (int val : arr) {
                System.out.println(val);
            }
        }
    }

    public static ArrayList<Integer> getListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        printListFromTailToHead(listNode, arr);
        return arr;
    }

    /**
     * 使用递归方法
     *
     * @param listNode
     * @param arr
     */
    private static void printListFromTailToHead(ListNode listNode, ArrayList<Integer> arr) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next, arr);
            arr.add(listNode.val);
            //System.out.println(listNode.val);
        }
    }

    /**
     * 使用栈
     *
     * @param listNode
     * @return
     */
    private static ArrayList<Integer> printListFromTailToHeadByStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
