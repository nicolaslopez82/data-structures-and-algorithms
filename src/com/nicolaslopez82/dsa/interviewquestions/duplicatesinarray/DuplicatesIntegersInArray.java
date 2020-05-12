package com.nicolaslopez82.dsa.interviewquestions.duplicatesinarray;

/**
 * Duplicates in an array problem.
 *
 * The problem is that we want to find duplicates in a one-dimensional array of integers
 * in O(N) running time     where the integer values are smaller than the length of the array!
 */

public class DuplicatesIntegersInArray {

    public void solve(int[] nArray){

        //This's why it is solved in a O(N) running time algorithm.
        for(int i = 0; i < nArray.length; i++){

            // If the value is positive, we have to flip it.
            if( nArray[Math.abs(nArray[i])] > 0 ){
                nArray[Math.abs(nArray[i])] = -nArray[Math.abs(nArray[i])];
            }else { //Otherwise it is negative: it's a repetition.
                System.out.println(Math.abs(nArray[i]) + " Is a repetition!!");
            }
        }
    }

}
