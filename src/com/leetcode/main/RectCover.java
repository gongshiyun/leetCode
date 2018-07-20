package com.leetcode.main;

/**
 * @author gongshiyun
 * @Description
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 解析：
 * 枚举发现结果是斐波那契数列，使用递归或循环法即可
 * @date 2018/7/20
 */
public class RectCover {

    public int rectCover(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return rectCover(n - 1) + rectCover(n - 2);
    }

    public int rectCoverByCycle(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        while (n-- > 2) {
            b += a;
            a = b - a;
        }

        return b;
    }
}
