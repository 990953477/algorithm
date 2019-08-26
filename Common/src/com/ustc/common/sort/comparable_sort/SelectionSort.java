package com.ustc.common.sort.comparable_sort;

import java.util.Arrays;

/**
 * 选择排序：
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
 *
 * @author tangfeng
 * @since 2019年08月25日 10:46
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 5, 0};
        SelectionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i; //0
            int min = nums[i];//4
            for (int j = i + 1; j < nums.length; j++) {
                //每次循环都找到一个最小的数
                if (min > nums[j]) {
                    minIndex = j;
                    min = nums[j];
                }
            }
            //将最小的数与未排好序的最后一个交换位置
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
