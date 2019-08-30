package com.ustc.nowcoder.sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 *
 * @author tangfeng
 * @since 2019年08月29日 14:03
 */
public class Question13 {
    public static void main(String[] args) {
        Question13 question = new Question13();
        System.out.println(question.LastRemaining_Solution(5, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 0)
            return -1;
        if (n == 1)
            return 0;

        LinkedList<Integer> array = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }

        int choose = 0;
        while (array.size() > 1) {
            int index = (choose + m - 1) % array.size();
            choose = index;
            array.remove(index);
        }
        return array.get(0);
    }
}
