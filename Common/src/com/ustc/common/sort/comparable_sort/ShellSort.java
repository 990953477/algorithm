package com.ustc.common.sort.comparable_sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author tangfeng
 * @since 2019年08月25日 10:46
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 5, 0};
        ShellSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int nums[]) {
        int len = nums.length;
        //不断缩小增量，最小的增量为1
        for (int gap = Math.floorDiv(len, 2); gap > 0; gap = Math.floorDiv(gap, 2)) {
            System.out.println("gap:" + gap);
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = nums[i];
                while (j - gap >= 0 && current < nums[j - gap]) {
                    nums[j] = nums[j - gap];
                    j = j - gap;
                }
                nums[j] = current;
            }
        }
    }
}
