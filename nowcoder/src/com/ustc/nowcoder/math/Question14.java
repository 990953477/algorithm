package com.ustc.nowcoder.math;

/**
 * @author tangfeng
 * @since 2019年08月29日 20:18
 */
public class Question14 {
    public static void main(String[] args) {
        Question14 question = new Question14();
        int result = question.StrToInt("-2147483647");
        System.out.println(result);
    }

    public int StrToInt(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        int sum = 0;
        int operator = 1;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (chars[0] == '-') {
                    operator = -1;
                    continue;
                } else if (chars[0] == '+') {
                    operator = 1;
                    continue;
                }
            }
            if (chars[i] <= '9' && chars[i] >= '0')
                sum += operator * (chars[i] - '0') * Math.pow(10, length - i - 1);
            else
                return 0;
        }
        return sum;
    }
}
