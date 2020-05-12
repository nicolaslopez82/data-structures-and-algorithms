package com.nicolaslopez82.dsa.interviewquestions.largestsumsubarray;

public class App {

    public static void main(String[] args) {

        int nArray[] = {1, -2, 3, 4, -5, 8 };
        LargestSumSubArray largestSumSubArray = new LargestSumSubArray();
        System.out.println(largestSumSubArray.solve(nArray));
    }

}
