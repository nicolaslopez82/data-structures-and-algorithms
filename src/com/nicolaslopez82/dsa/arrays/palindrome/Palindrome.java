package com.nicolaslopez82.dsa.arrays.palindrome;

public class Palindrome {

    public boolean checkPalindromeOrNot(String palindrome){
        int startIndex = 0;
        int endIndex = palindrome.length() -1;

        boolean isAnagram = false;

        do{
            isAnagram = comparePalindromeChar(palindrome, startIndex, endIndex);

            endIndex--;
            startIndex++;
        } while ((endIndex > startIndex) && isAnagram == true);

        return isAnagram;
    }

    private boolean comparePalindromeChar(String str, int startIndex, int endIndex){
        if(str.charAt(startIndex) == str.charAt(endIndex)){
            return true;
        }else {
            return false;
        }
    }
}
