package com.nicolaslopez82.dsa.arrays.reversingarrayinplace;

/**
 * Interview Question #1
 *
 * The problem is that we want to reverse a T[] array in O(N) linear time complexity and we want the algorithm to be in-place as well!
 *
 * For example: input is [1,2,3,4,5] then the output is [5,4,3,2,1]
 */

public class ReverseArray {

    /**
     * The running time complexity is O(N) + in place algorithm (not need for extra memory).
     * @param nums
     * @return
     */
    public int[] reverseArray(int[] nums){

        int startIndex = 0;
        int endIndex = nums.length -1;

        /**
         * We swap 2 items in 1 iteration. Therefore, we just have to make N/2 iterations.
         */
        while (endIndex > startIndex){

            swap(nums, startIndex, endIndex);

            endIndex--;
            startIndex++;
        }

        return nums;

    }

    public void swap(int[] nums, int startIndex, int endIndex){
        int temp = nums[startIndex];
        nums[startIndex] = nums[endIndex];
        nums[endIndex] = temp;
    }

}
