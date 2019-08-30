package com.ustc.nowcoder.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangfeng
 * @since 2019年08月27日 21:46
 */
public class Question05 {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.remove(array[i]);
            } else {
                map.put(array[i], 1);
            }
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i == 0){
                num1[0] = entry.getValue();
            }else{
                num2[0] = entry.getValue();
                break;
            }
            i++;
        }
    }
}
