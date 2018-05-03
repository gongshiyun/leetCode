package com.leetcode.main;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 例如，
 * s = "anagram"，t = "nagaram"，返回 true
 * s = "rat"，t = "car"，返回 false
 *
 * 注意:
 * 假定字符串只包含小写字母。
 *
 * 提升难度:
 * 输入的字符串包含 unicode 字符怎么办？你能能否调整你的解法来适应这种情况？
 *
 * @author gongshiyun
 * @date: 2018/5/3 21:24
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("car","tar"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)){
            return true;
        }

        final int ARR_LEN = 26;
        int len = s.length();
        int i;

        int[] arr1 = new int[ARR_LEN];
        int[] arr2 = new int[ARR_LEN];

        for (i = 0; i < len; i++) {
            arr1[s.charAt(i)-'a']++;
            arr2[t.charAt(i)-'a']++;
        }

        for (i = 0; i < ARR_LEN; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

}
