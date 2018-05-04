package com.leetcode.main;

import com.leetcode.entity.ListNode;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author gongshiyun
 * @date: 2018/5/5 0:05
 */
public class MergeKLists {
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

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l4;
        lists[2] = l1;

        ListNode result = mergeKLists(lists);
        System.out.print(result.val);
        while (result.getNext() != null) {
            System.out.print(" -> ");
            result = result.getNext();
            System.out.print(result.getVal());
        }
    }

    /**
     * 暴力方法
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode headNode = new ListNode(0);
        ListNode curNode = headNode;
        int len = lists.length;
        //最小值
        int min;
        //最小值在lists中的位置
        int minIndex;
        //判断是否全部节点都为null
        Boolean allNullFlag = false;
        while (!allNullFlag) {
            min = Integer.MAX_VALUE;
            minIndex = -1;
            allNullFlag = true;
            for (int i = 0; i < len; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        minIndex = i;
                    }
                    allNullFlag = false;
                }
            }
            if (!allNullFlag) {
                curNode.next = new ListNode(min);
                curNode = curNode.next;
                lists[minIndex] = lists[minIndex].next;
            }

        }

        return headNode.next;
    }

    /**
     * 思路:把所有链表头结点最小值保存在排序数组中,每次取出其中最小值插入结果链表
     * 并把这个最小值所在链表头指向其下一位,再把下一位的值插入排序数组中进行排序
     * 如此循环
     */
    public static ListNode mergeKListsNew(ListNode[] lists) {
        //TODO
        return null;
    }

    /**
     * 归并排序思想
     */
    public static ListNode mergeKListsFast(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return work(lists, 0, lists.length - 1);
    }

    /**
     * 利用归并排序的思想
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private static ListNode work(ListNode[] lists, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            ListNode l1 = work(lists, left, mid);
            ListNode l2 = work(lists, mid + 1, right);
            return mergeTwo(l1, l2);
        }
        //如果left==right则直接返回左面的链表
        return lists[left];
    }

    /**
     * 合并两个的方法
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l2.next, l1);
            return l2;
        }
    }
}
