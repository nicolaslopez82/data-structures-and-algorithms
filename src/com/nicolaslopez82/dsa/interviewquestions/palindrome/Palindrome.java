package com.nicolaslopez82.dsa.interviewquestions.palindrome;

/**
 *
 * Palindrome problem
 *
 * "A palindrome is a string that reads the same forward and backward"
 *
 * For example: radar or madam
 *
 * Our task is to design an optimal algorithm for checking whether a given
 * string is palindrome or not!
 */

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(palindrome1("neuqutn"));
        System.out.println(palindrome2("neuquen"));
    }

    public static boolean palindrome1(String str){
        String reversed = "";
        int length = str.length();

        for (int i = 0; i < length; i++){
            reversed = reversed + str.charAt(length - i - 1);
        }

        if(str.equals(reversed)){
            return true;
        }
        return false;
    }

    private static boolean palindrome2(String str){

        int i = 0;
        int j = str.length() -1;
        int k = (i + j) / 2;

        for (int index = i; index <= k; index++){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

}
