package com.ustc.common.sort.comparable_sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author tangfeng
 * @since 2019年08月25日 10:46
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 8, 5, 7};
        HeapSort.buildMaxRootHeap(nums);
        int size = nums.length - 1;
        for (int i = 0; i < size; i++) {
            swap(nums, 0, size - i);
            heapify(nums, 0, size - i);
        }
        System.out.println(Arrays.toString(nums));
    }

    //构建大根堆
    public static void buildMaxRootHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;
            while (arr[currentIndex] > arr[fatherIndex]) {
                //1.交换当前节点
                swap(arr, currentIndex, fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    //调整大根堆
    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            //1.判断孩子中较大的那一个
            int largestIndex;
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //2.判断父节点与较大值的比较
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //3.如果父节点是最大的，表示不需用调整，跳出循环
            if (index == largestIndex) {
                break;
            }
            //4.若父节点不是最大的，需要调整
            swap(arr, largestIndex, index);
            //5. 将索引指向孩子中较大的值得索引
            index = largestIndex;
            //6. 重新计算子节点
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private static void swap(int[] arr, int current, int other) {
        int tmp = arr[current];
        arr[current] = arr[other];
        arr[other] = tmp;
    }
}
