package com.nicolaslopez82.dsa.interviewquestions.anagramproblem;

import java.util.Arrays;

public class AnagramProblem {

    public boolean solve(char[] str1, char[] str2){

        if(str1.length != str2.length){ return false; }

        //Bottleneck because it has O(NlogN) running time.
        Arrays.sort(str1);
        Arrays.sort(str2);

        //Running time is O(N).
        //O(NlogN) + O(N) = O(NlogN).
        for(int i = 0; i < str1.length; i++){
            if(str1[i] != str2[i]){
                return false;
            }
        }
        return true;
    }

}
