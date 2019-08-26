package com.ustc.common.sort.comparable_sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author tangfeng
 * @since 2019年08月25日 10:45
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 5, 0};
        InsertionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 1; i < nums.length; i++) {
            int preIndex = i - 1;
            int current = nums[i];
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }
}
