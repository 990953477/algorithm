package com.ustc.nowcoder.dp;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tangfeng
 * @since 2019年08月30日 16:38
 */
public class Question16 {
    public static void main(String[] args) {
        Question16 question = new Question16();
        //char[] str = {'a', 'a', 'a'};
        //char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        //char[] str = {'a', 'a', 'a'};
        //char[] pattern = {'a', 'b', '*', 'a'};
        //char[] str = {'a', 'a'};
        //char[] pattern = {'a', '*'};
        char[] str = {'a','a'};
        char[] pattern = {'a','*'};
        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(pattern));
        System.out.println(question.match(str, pattern));
    }

    /**
     * 转移函数：
     * 1. s(i) == p(j) ==> f(i,j) = f(i-1, j-1)
     * 2. p(j) == '.' ==> f(i,j) = f(i-1,j-1)
     * 3. p(j) == '*' ==> f(i,j) = f(i, j-2) || f(i, j-1) || ( f(i-1,j) && s(i)==s(j-1))
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length == 0)
            return true;
        if (pattern.length == 2 && pattern[0] == '.' && pattern[1]=='*')
            return true;
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        //初始化,除了dp[0][0]为1，其他都为0
        //初始化第一行
        for (int i = 0; i < dp[0].length; i++) {
            if (i == 0) {
                dp[0][0] = true;
                continue;
            }
            else if (pattern[i - 1] == '.') {
                dp[0][i] = false;
            } else if (pattern[i - 1] == '*') {
                dp[0][i] = (i > 1 ? dp[0][i - 2] : false) || dp[0][i - 1];
            }
        }

        //循环遍历, 外层循环针对str，内层循环针对pattern
        for (int i = 1; i <= str.length; i++) {
            char currChar = str[i - 1];
            for (int j = 1; j <= pattern.length; j++) {
                char pattChar = pattern[j - 1];
                //转移函数
                if (currChar == pattChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattChar == '*') {
                    dp[i][j] = dp[i][j - 1] ||
                            (dp[i - 1][j] && (currChar == pattern[j - 2] || pattern[j - 2] == '.')) ||
                            (j > 1 ? dp[i][j - 2] : false);
                }
            }
        }

        return dp[str.length][pattern.length];
    }
}
