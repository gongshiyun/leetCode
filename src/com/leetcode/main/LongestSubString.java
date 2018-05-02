package com.leetcode.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 *
 * @author gongshiyun
 * @date: 2018/5/3 0:37
 *
 */
public class LongestSubString {
    public static void main(String[] args) {
        String test = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(test));
    }

    /**
     * 暴力方法:第一时间想出
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        char str[] = s.toCharArray();
        int len = str.length;
        int i = 0;
        int j = 0;
        int maxSubLen = 0;
        int result = 1;
        for (; i < len; i++) {
            if (map.containsKey(str[i])) {
                i = j;
                ++j;
                if (result < maxSubLen) {
                    result = maxSubLen;
                }
                maxSubLen = 0;
                map.clear();
            } else {
                map.put(str[i], 1);
                ++maxSubLen;
            }
        }

        if (result < maxSubLen) {
            result = maxSubLen;
        }

        return result;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // map记录字符的之前出现的位置
        Map<Character, Integer> lastPosition = new HashMap<>();
        // 字符串数组
        char str[] = s.toCharArray();
        // 字符串数组长度
        int len = str.length;
        // 记录以str[i]结尾的字符串的最长无重复子串长度
        int[] maxlenOfEndCharArr = new int[len];
        int result = 0;
        int i = 0;
        for (; i < len; i++) {
            // 如果之前已经出现过这个字符
            if (lastPosition.containsKey(str[i])) {
                // 之前出现的位置
                int pos = lastPosition.get(str[i]);
                // 前一个字符前的最长无重复子串长度
                int preMaxSubLen = maxlenOfEndCharArr[i - 1];
                //TODO

            } else {
                maxlenOfEndCharArr[i] = i == 0 ? 1 : maxlenOfEndCharArr[i - 1] + 1;
                lastPosition.put(str[i], i);
            }
        }
        return result;
    }
}
