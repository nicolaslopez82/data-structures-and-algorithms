package com.nicolaslopez82.dsa.arrays.reservoirsalgorithm;

import java.util.Random;

/**
 * Interview Question #4:
 *
 * Our task is to design an algorithm thats capable of selecting k items from an array! The problem is that the n size of the array is unknown (or infinitely large)!
 */

public class ReservoirAlgorithm {

    private Random random;

    public ReservoirAlgorithm() {
        this.random = new Random();
    }

    //O(N) algorithm to get k items at random from array nums
    public void reservoirAlgorithmSolve(int[] nums, int k){

        //Create an array with k size.
        int[] reservoirArray = new int[k];

        //Create the first k items from the original array.
        for(int i = 0; i < reservoirArray.length; i++){
            reservoirArray[i] = nums[i];
        }

        //show the k random items
        for(int i=0;i<reservoirArray.length;i++)
            System.out.print("first for ==> " + reservoirArray[i] + " " + '\n');

        //We consider the items from the original array
        //k+1 because we have already copied k items
        //the i-th items is chosen to be included in the
        //reservoirArray with probability k/i.
        for(int i = k+1; i < nums.length; i++){
            int j = random.nextInt(i)+1;
            if( j < k ) reservoirArray[j] = nums[i];
        }

        //show the k random items
        for(int i=0;i<reservoirArray.length;i++)
            System.out.print(reservoirArray[i]+" ");
    }


}
