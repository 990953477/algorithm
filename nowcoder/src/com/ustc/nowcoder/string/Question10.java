package com.ustc.nowcoder.string;

/**
 * @author tangfeng
 * @since 2019年08月29日 12:04
 */
public class Question10 {
    public static void main(String[] args) {
        Question10 question10 = new Question10();
        String result = question10.ReverseSentence("I am a student.");
        System.out.println(result);
    }

    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0 || " ".equals(str)){
            return str;
        }

        StringBuilder sb = new StringBuilder();
        int length = str.length();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < length; i++){
            if (str.charAt(length - i -1) != ' '){
                word.append(str.charAt(length - i -1));
            }else{
                sb.append(word.reverse()).append(str.charAt(length - i - 1));
                word = new StringBuilder();
            }
        }
        sb.append(word.reverse());

        return sb.toString();
    }
}
