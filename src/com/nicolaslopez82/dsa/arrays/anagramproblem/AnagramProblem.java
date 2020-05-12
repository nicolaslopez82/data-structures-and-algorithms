package com.nicolaslopez82.dsa.arrays.anagramproblem;

import java.util.Arrays;

/**
 * Interview Question #2:
 *
 * Construct an algorithm to check whether two words (or phrases) are anagrams or not!
 *
 * "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once"
 *
 * For example: restful - fluster.
 */

public class AnagramProblem {

    public boolean checkAnagramOrNot(String anagram1, String anagram2){

        boolean isAnagram;
        int index = 0;

        do{
            isAnagram = isEqualChar(anagram1, anagram2, index);
            index++;
        }while ((isAnagram == true) && index < anagram1.length());

        return isAnagram;
    }

    private boolean isEqualChar(String anagram1, String anagram2, int index){
       return anagram2.indexOf(anagram1.charAt(index)) != -1 ? true : false;
    }

    public boolean isAnagram(char[] c1, char[] c2){

        if(c1.length != c2.length) return false;

        //Bottleneck because it has O(NlogN) running time. So, we need to sort these arrays.
        Arrays.sort(c1);
        Arrays.sort(c2);

        //Running time is O(N)
        for(int i=0; i < c1.length; i++){
            if(c1[i]!=c2[i]) return false;
        }
        return true;
    }
}
