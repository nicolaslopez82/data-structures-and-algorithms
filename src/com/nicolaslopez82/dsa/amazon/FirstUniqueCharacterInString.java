package com.nicolaslopez82.dsa.amazon;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author nicolaslopez82
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Details:
 * Runtime: 24 ms, faster than 30.56% of Java online submissions for First Unique Character in a String.
 * Memory Usage: 40.1 MB, less than 49.28% of Java online submissions for First Unique Character in a String.
 */

public class FirstUniqueCharacterInString {

    public static void main(String[] args){
        FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();
        String str = "leetcode";
        System.out.println(firstUniqueCharacterInString.solve(str));
    }

    private int solve(String str){

        if(str.length() == 0) return -1;

        Map<Character, Integer> map = new LinkedHashMap();

        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i], -1);
            }else{
                map.put(chars[i], i);
            }
        }

        for (char c: map.keySet()) {
            if(map.get(c) != -1 ) return map.get(c);
        }
        return -1;
    }

}
