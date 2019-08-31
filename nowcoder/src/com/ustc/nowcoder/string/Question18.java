package com.ustc.nowcoder.string;

import java.util.HashMap;

/**
 * @author tangfeng
 * @since 2019年08月30日 21:08
 */
public class Question18 {

    public StringBuilder sb = new StringBuilder();
    public HashMap<Character, Integer> map = new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (map.get(chars[i])==1){
                return chars[i];
            }
        }
        return '#';
    }
}
