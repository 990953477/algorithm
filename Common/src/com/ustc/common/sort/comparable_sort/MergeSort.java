package com.ustc.common.sort.comparable_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 归并排序算法
 * 采用分治思想-递归思想
 *
 * @author tangfeng
 * @since 2019年08月25日 10:42
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 5, 0};
        MergeSort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static void sort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        int divideIndex = (startIndex + endIndex) / 2;
        sort(nums, startIndex, divideIndex);
        sort(nums, divideIndex + 1, endIndex);
        merge(nums, startIndex, divideIndex, endIndex);
    }

    private static void merge(int[] nums, int start, int divideIndex, int end) {
        int part1 = start;
        int part2 = divideIndex + 1;
        List<Integer> tmp = new ArrayList<>();
        while (part1 <= divideIndex && part2 <= end) {
            if (nums[part1] < nums[part2]){
                tmp.add(nums[part1]);
                part1++;
            }else{
                tmp.add(nums[part2]);
                part2++;
            }
        }
        if (part1 <= divideIndex){
            while (part1 <= divideIndex){
                tmp.add(nums[part1]);
                part1++;
            }
        }
        if (part2 <= end){
            while (part2 <= end){
                tmp.add(nums[part2]);
                part2++;
            }
        }
        for (int m : tmp){
            nums[start++] = m;
        }
    }
}
