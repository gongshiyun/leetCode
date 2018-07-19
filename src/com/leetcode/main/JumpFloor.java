package com.leetcode.main;

/**
 * @author gongshiyun
 * @Description 跳台阶：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @date 2018/7/19
 */
public class JumpFloor {
    /**
     * 思路：有两种跳法，一种跳一阶，另一种跳两阶;
     * 第一次跳如果跳一阶，剩下为f(n-1);
     * 如果跳两阶，剩下为f(n-2);
     * 所以f(n) = f(n-1) + f(n-2)。
     * 可以看出这是一个斐波那契数列。
     * 使用循环法。
     *
     * @param n
     * @return
     */
    public int jumpFloor(int n) {
        if (n < 0) {
            throw new RuntimeException("参数不能小于0");
        }
        if (n <= 2) {
            return n;
        }

        int num1 = 1;
        int num2 = 2;
        while (n-- > 2) {
            num2 += num1;
            num1 = num2 - num1;
        }

        return num2;
    }
}
