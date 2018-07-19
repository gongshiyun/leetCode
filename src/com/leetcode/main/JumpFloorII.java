package com.leetcode.main;

/**
 * @author gongshiyun
 * @Description 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法
 * @date 2018/7/19
 */
public class JumpFloorII {
    /**
     * 思路：
     * 找规律得出该结论：
     *        | 1  n=0
     * f(n) = | 1  n=1
     *        | 2*f(n-1) n > 1
     * @param n
     * @return
     */
    public static int jumpFloorII(int n) {
        if (n <= 0) {
            throw new RuntimeException("参数不能小于0");
        }

        return 1 << (n - 1);
    }

}
