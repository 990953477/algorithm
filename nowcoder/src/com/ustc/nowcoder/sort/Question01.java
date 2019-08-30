package com.ustc.nowcoder.sort;

import java.util.ArrayList;

/**
 * 数组中的逆序对：可以采用归并排序的思想进行实现
 * 时间复杂度 O(nlg(n))
 *
 * @author tangfeng
 * @since 2019年08月26日 21:44
 */
public class Question01 {
    public int count = 0;

    public static void main(String[] args) {
        Question01 question = new Question01();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        question.count(nums, 0, nums.length - 1);
        System.out.println(question.count);
    }

    public void count(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int middle = (start + end) / 2;
        count(nums, start, middle);
        count(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int index1 = start;
        int index2 = middle + 1;
        ArrayList<Integer> tmpArr = new ArrayList<>();
        //统计合并过程中的逆序数
        while (index1 <= middle && index2 <= end) {
            count += nums[index1] > nums[index2] ? (middle - index1 + 1) : 0;
            tmpArr.add(nums[index1] < nums[index2] ? nums[index1++] : nums[index2++]);
        }
        if (index1 >= middle) {
            for (int i = index2; i <= end; i++) {
                tmpArr.add(nums[i]);
            }
        }
        if (index2 >= end) {
            for (int i = index1; i <= middle; i++) {
                tmpArr.add(nums[i]);
            }
        }

        for (int i = 0; i < tmpArr.size(); i++) {
            nums[start++] = tmpArr.get(i);
        }
    }
}
