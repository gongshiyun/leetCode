package com.leetcode.main;

/**
 * @author gongshiyun
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @date 2018/7/19
 */
public class MinNumberInRotateArray {

    /**
     * 遍历数组，找到第一个比数组第一位小的数即为最小值
     *
     * @param array
     * @return
     */
    public int minInOrder(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                break;
            }
        }

        return min;
    }

    /**
     * 使用二分查找最小数
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int[] array) {
        if (array == null) {
            throw new NullPointerException("数组为空");
        }
        if (array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            // 数组为非减排序，旋转后可能出现左右中位置的数相等的情况
            // 如非减排序数组[0,1,1,1,1]，旋转后可能为[1,0,1,1,1],[1,1,1,0,1]
            // 这种情况直接遍历数组
            if (array[left] == array[mid] && array[mid] == array[right]) {
                return minInOrder(array);
            }
            if (array[mid] <= array[right]) {
                right = mid;
            } else if (array[mid] >= array[left]) {
                left = mid;
            }
        }
        return array[mid];
    }


}
