package com.leetcode.main;

import java.util.HashMap;

/**
 * 给定两个数组，写一个函数来计算它们的交集。
 *
 * 例子:
 *
 * 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 *
 * 提示:
 *
 * 每个在结果中的元素必定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author gongshiyun
 * @date: 2018/5/3 21:48
 */
public class Intersection {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int i;
        int k = 0;
        //两个数组长度最长的值
        final int maxLen = Math.max(nums1.length, nums2.length);
        //交集
        int[] intersection = new int[maxLen];
        int[] result = new int[0];
        //保存数组出现数字
        HashMap<Integer, Boolean> map = new HashMap<>(16);

        for (i = 0; i < nums1.length; i++) {
            map.put(nums1[i], true);
        }

        for (i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i])){
                    intersection[k++] = nums2[i];
                    map.put(nums2[i],false);
                }
            }
        }

        if (k != 0) {
            result = new int[k];
            for (i = 0; i < k; i++) {
                result[i] = intersection[i];
            }
        }

        return result;
    }
}
