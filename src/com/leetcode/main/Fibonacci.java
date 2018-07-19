package com.leetcode.main;

/**
 * @author gongshiyun
 * @Description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @date 2018/7/19
 */
public class Fibonacci {

    /**
     * 递归法：重复计算情况过多
     *
     * @param n
     * @return
     */
    public int fibonacciByRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciByRecursive(n - 1) + fibonacciByRecursive(n - 2);
    }

    /**
     * 使用循环
     *
     * @param n
     * @return
     */
    public int fibonacciByCycle(int n) {
        if (n < 0) {
            throw new RuntimeException("参数不能为负");
        }
        int num1 = 0;
        int num2 = 1;
        while (n-- > 0) {
            num2 += num1;
            num1 = num2 - num1;
        }
        return num1;
    }
}
