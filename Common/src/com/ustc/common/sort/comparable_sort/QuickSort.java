package com.ustc.common.sort.comparable_sort;

import java.util.Arrays;

/**
 * 快速排序算法
 *
 * @author tangfeng
 * @since 2019年08月25日 10:41
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 2, 5, 0};
        QuickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high){
            return;
        }
        int middle = partition(nums, low, high);
        System.out.println(middle);
        quickSort(nums, low, middle - 1);
        quickSort(nums, middle + 1, high);
    }

    //一次循环，比基数小的全在左边，比基数大的全在右边
    private static int partition(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            //找到第一个比基数还要小的数，否则high的指针向左移动一位
            while (low < high && nums[high] >= tmp) {
                high--;
            }
            nums[low] = nums[high];
            //找到第一个比基数大的数，否则low的指针想右移动一位
            while (low < high && nums[low] <= tmp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }
}
