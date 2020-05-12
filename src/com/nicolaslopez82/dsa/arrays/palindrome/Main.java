package com.nicolaslopez82.dsa.arrays.palindrome;


/**
 * Interview Question #2.2:
 *
 * Construct an algorithm to check whether one word is palindrome or not!
 *
 * For example: neuquen.
 */

public class Main {

    public static void main(String[] args) {
        String strWord = "neuquen";

        Palindrome palindrome = new Palindrome();

        System.out.println(palindrome.checkPalindromeOrNot(strWord));
    }
}
