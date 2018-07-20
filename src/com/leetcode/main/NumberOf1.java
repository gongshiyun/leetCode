package com.leetcode.main;

/**
 * @author gongshiyun
 * @Description 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @date 2018/7/20
 */
public class NumberOf1 {

    /**
     * n与n-1做与运算,将n二进制最后一位1的位置之后都变为0,
     * 当n最后为0时说明二进制中已经没有1
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }

        return count;
    }

    /**
     * n与1做与运算，结果为1说明n最后一位为1
     * 然后对n进行无符号右移，循环以上操作，直到n为0
     *
     * @param n
     * @return
     */
    public int solution2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
