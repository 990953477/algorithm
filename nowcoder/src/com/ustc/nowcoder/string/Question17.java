package com.ustc.nowcoder.string;

/**
 * @author tangfeng
 * @since 2019年08月30日 20:28
 */
public class Question17 {
    public static void main(String[] args) {
        Question17 question = new Question17();
        char[] chars = {'1','0','9'};
        System.out.println(question.isNumeric(chars));
    }
    public boolean isNumeric(char[] str) {
        if (str == null)
            return false;
        return String.valueOf(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([Ee]+[\\+\\-]?\\d+)?");
    }
}
