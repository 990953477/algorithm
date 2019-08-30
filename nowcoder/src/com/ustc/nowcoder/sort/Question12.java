package com.ustc.nowcoder.sort;

/**
 * 扑克牌问题
 *
 * @author tangfeng
 * @since 2019年08月29日 12:57
 */
public class Question12 {
    public static void main(String[] args) {
        Question12 question = new Question12();
        int[] numbers = {1, 3, 0, 5, 0};
        boolean result = question.isContinuous(numbers);
        System.out.println(result);
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        int minNum = 14;
        int maxNum = -1;
        int[] cardNumber = new int[14];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                if (cardNumber[numbers[i]] >= 1) {
                    return false;
                } else {
                    cardNumber[numbers[i]]++;
                    if (numbers[i] < minNum) {
                        minNum = numbers[i];
                    }
                    if (numbers[i] > maxNum) {
                        maxNum = numbers[i];
                    }
                }
            } else {
                cardNumber[0]++;
                if (cardNumber[0] > 4) {
                    return false;
                }
            }
        }
        if (maxNum - minNum < numbers.length) {
            return true;
        }
        return false;
    }
}
