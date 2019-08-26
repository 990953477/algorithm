package com.ustc.common.sort.comparable_sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author tangfeng
 * @since 2019年08月25日 10:44
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 5};
        BubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 升序排序
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) { //相邻的两个进行比较
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
