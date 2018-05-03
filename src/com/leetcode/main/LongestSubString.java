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
 */
public class LongestSubString {
    public static void main(String[] args) {
        String test = "abba";
        System.out.println(lengthOfLongestSubstring4(test));
    }

    /**
     * 暴力方法:第一时间想出
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
                //Test
            } else {
                maxlenOfEndCharArr[i] = i == 0 ? 1 : maxlenOfEndCharArr[i - 1] + 1;
                lastPosition.put(str[i], i);
            }
        }
        return result;
    }

    /**
     * 简洁代码
     * 思想:前后两个指针指向子串第一位和最后一位,
     * 位置保存在map中,key为char,值为位置下标
     */
    private static int lengthOfLongestSubstring3(String s) {
        //把字符串保存在字符数组中
        HashMap<Character, Integer> map = new HashMap<>(16);
        //无重复子串长度最大值
        int max = 0;
        //i为子串最后一位,j为子串第一位
        //移动i同时记录字符在字符数组中的位置
        for (int i = 0, j = 0; i < s.length(); i++) {
            //当key存在时,说明前面出现了该字符
            //这时需要改变子串头位置j的值,保证该子串不存在重复字符
            if (map.containsKey(s.charAt(i))) {
                //j的值为上次出现字符的后面一位,或者不变,取两者中的最大值
                //这是因为避免j回退的问题,例如"abba"
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            //结果为当前子串长度和max的最大值
            max = Math.max(i - j + 1, max);
            //更新字符位置
            map.put(s.charAt(i), i);
        }
        return max;
    }

    /**
     * 最优解
     * 思想与上面方法类似,区别在于用list保存字符位置
     */
    public static int lengthOfLongestSubstring4(String s) {
        int[] list = new int[256];
        int previous = -1, right = 0, max_len = 0;
        for (int i = 0; i < list.length; i++) {
            list[i] = -1;
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            //避免previous子串头位置回退
            if (list[(int) c] > previous)
                previous = list[(int) c];
            max_len = Math.max(max_len, right - previous);
            list[(int) c] = right++;
        }
        return max_len;
    }


}
