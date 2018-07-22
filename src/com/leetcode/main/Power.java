package com.leetcode.main;

/**
 * @author gongshiyun
 * @Description 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @date 2018/7/20
 */
public class Power {

    public double solution1(double base,int exponent) {
        double result = 1;
        int k = Math.abs(exponent);
        if (exponent == 0) {
            return result;
        }

        result = base;
        while (--k > 0) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }
}
