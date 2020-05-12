package com.nicolaslopez82.dsa.interviewquestions.integerreversion;

/**
 * Integer reversion problem.
 *
 * Our task is to design an efficient algorithm to reverse a given integer.
 * For example if the input of the algorithm is 1234 then the output should be 4321.
 */

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }

    public static int reverse(int n){
        int reverse = 0;
        int reminder = 0;

        while(n > 0){
            reminder = n % 10;
            n = n / 10;
            reverse = reverse * 10 + reminder;
        }
        return reverse;
    }
}
