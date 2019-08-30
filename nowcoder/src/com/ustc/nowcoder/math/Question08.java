package com.ustc.nowcoder.math;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author tangfeng
 * @since 2019年08月28日 14:50
 */
public class Question08 {
    public static void main(String[] args) {
        Question08 question = new Question08();
        int[] arr = {1,2,3,4,5,7,9,10,12};
        ArrayList<Integer> result = question.FindNumbersWithSum(arr, 11);
        System.out.println(result);
    }
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (array == null || array.length == 0)
            return arr;

        int left = 0;
        int right = array.length - 1;
        long multify = Long.MAX_VALUE;
        while (left < right) {
            int total = array[left] + array[right];
            if (total == sum) {
                if (array[left] * array[right] < multify) {
                    multify = array[left] * array[right];
                    arr.clear();
                    arr.add(array[left]);
                    arr.add(array[right]);
                }
                left++;
                right--;
            }
            if (total < sum) {
                left++;
            }
            if (total > sum) {
                right--;
            }

        }

        return arr;
    }
}
