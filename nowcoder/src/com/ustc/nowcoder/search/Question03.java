package com.ustc.nowcoder.search;

/**
 * 二分查找法
 *
 * @author tangfeng
 * @since 2019年08月27日 18:23
 */
public class Question03 {
    public static void main(String[] args) {
        Question03 question = new Question03();
        int[] array = {3, 3, 3, 3, 4, 5};
        int result = question.GetNumberOfK(array, 3);
        System.out.println(result);
    }

    public int firstIndex = -1;
    public int lastIndex = -1;

    public int GetNumberOfK(int[] array, int k) {
        getK(array, 0, array.length, k);
        if (firstIndex == -1 && lastIndex == -1)
            return 0;
        return lastIndex - firstIndex - 1;
    }

    public void getK(int[] array, int start, int end, int k) {
        if (start > end) {
            return;
        }
        int middle = (start + end) / 2;
        if (array[middle] == k) {
            int tmp = middle;
            while (tmp >= 0 && array[tmp] == array[middle]) {
                tmp--;
            }
            firstIndex = tmp;

            tmp = middle;
            while (tmp < array.length && array[tmp] == array[middle]) {
                tmp++;
            }
            lastIndex = tmp;

            return;
        }
        getK(array, start, middle - 1, k);
        getK(array, middle + 1, array.length - 1, k);
    }
}
