package com.ustc.nowcoder.string;

/**
 * @author tangfeng
 * @since 2019年08月29日 11:57
 */
public class Question09 {
    public static void main(String[] args) {
        Question09 question = new Question09();
        question.LeftRotateString("abcXYZdef", 3);
    }
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return str;
        }
        n = n % str.length();
        StringBuilder sb = new StringBuilder(str);
        sb.append(sb.substring(0, n));
        sb.delete(0, n);
        return sb.toString();
    }
}
