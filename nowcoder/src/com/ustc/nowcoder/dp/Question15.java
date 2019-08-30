package com.ustc.nowcoder.dp;

/**
 * 构建乘积数组
 *
 * @author tangfeng
 * @since 2019年08月30日 14:26
 */
public class Question15 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A == null || A.length == 0)
            return B;

        int length = A.length;
        //先计算左下部分
        for (int i = 0; i < length; i++) {
            if (i == 0)
                B[0] = 1;
            else {
                B[i] = B[i - 1] * A[i - 1];
            }
        }
        //再计算右上部分
        int tmp = 1;
        for (int j = length - 2; j >= 0; j--) {
            tmp = tmp * A[j + 1];
            B[j] = tmp * B[j];
        }

        return B;
    }
}
