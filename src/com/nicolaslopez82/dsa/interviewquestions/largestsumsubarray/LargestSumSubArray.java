package com.nicolaslopez82.dsa.interviewquestions.largestsumsubarray;

/**
 *
 * Largest sum subarray problem.
 *
 * Create an algorithm to find the sum of contiguous subarray within
 * a one-dimensional array of numbers which has the largest sum!
 *
 * Kanade's algorithm solves this problem in O(N) running time complexity.
 *
 * We can solve it with Dynamic Programming using the formula:
 *
 * current_max: tracks the max of the actual subarray that we are considering (it ends with the current i index).
 * current_max = max(nums[i], current_max + nums[i])
 *
 * global_max: the largest subarray sum
 * global_max = current_max (if( current_max > global_max))
 *
 */

public class LargestSumSubArray {

    public int solve(int[] nArray){

        //Initialize the algorithm with the first item in the array.
        int current_value = 0;
        int global_value = 0;

        //It has an O(N) linear running time complexity.
        for (int i = 0; i < nArray.length; i++){
            current_value = Math.max(nArray[i], current_value + nArray[i]);
            if (current_value > global_value){
                global_value = current_value;
            }
        }
        return global_value;
    }

}
