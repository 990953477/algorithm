package com.ustc.nowcoder.math;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 连续正数序列
 * 解法1：利用数学性质
 * 解法2：利用双指针
 *
 * @author tangfeng
 * @since 2019年08月28日 13:41
 */
public class Question07 {
    public static void main(String[] args) {
        Question07 question = new Question07();
        ArrayList<ArrayList<Integer>> array = question.FindContinuousSequence(100);
        System.out.println(array.toString());
    }

    /**
     * 双指针
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        if (sum < 0) {
            return array;
        }
        int maxNum = sum / 2 + 1;
        int minNum = 1;
        int leftPointer = minNum;
        int rightPointer = 2;
        while (leftPointer < rightPointer && rightPointer <= maxNum) {
            int tmpResult = compute(leftPointer, rightPointer);
            System.out.println(tmpResult);
            //右指针右移
            if (tmpResult < sum) {
                rightPointer++;
            } else if (tmpResult == sum) {
                ArrayList<Integer> item = new ArrayList<>();
                for (int i = leftPointer; i <= rightPointer; i++){
                    item.add(i);
                }
                array.add(item);
                rightPointer++;
                leftPointer++;
            } else{
                //左指针右移
                leftPointer++;
            }
        }

        return array;
    }

    public int compute(int min, int max) {
        return (min + max) * (max - min + 1) / 2;
    }
}
