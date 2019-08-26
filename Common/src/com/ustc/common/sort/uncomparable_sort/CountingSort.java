package com.ustc.common.sort.uncomparable_sort;

import com.ustc.common.sort.comparable_sort.QuickSort;

import java.util.Arrays;

/**
 * 非比较排序算法 - 计数排序
 *
 * @author tangfeng
 * @since 2019年08月25日 10:47
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, -1, 3, 2, 5, 0};
        CountingSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        //1.先找出最大值和最小值
        int minNum = nums[0], maxNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (minNum > nums[i])
                minNum = nums[i];
            if (maxNum < nums[i])
                maxNum = nums[i];
        }
        int[] arr = new int[maxNum - minNum + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - minNum]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[count++] = i + minNum;
            }
        }
    }
}
