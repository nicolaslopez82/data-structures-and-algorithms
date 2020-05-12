package com.nicolaslopez82.dsa.arrays.duplicatesinarray;

/**
 * Find duplicates in one-dimensional array of Integers in O(N) running time
 * where the integer values are smaller than the length of the array.
 *
 * Resolving through Absolute Values: With this approach, I can achieve O(N)
 * running time algorithm that is in-place as well.
 */

public class DuplicatesInArray {

    public void findDuplicatesInArray(int[] array){

        //This's why it's on O(N) Linear running time algorithm.
        for(int i = 0; i < array.length; i++){

            //If this value is positive, we have to flip.
            if( array[Math.abs(array[i])] > 0 ){
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
                System.out.println("array[i] => " + array[i]);
            }else {
                System.out.println(Math.abs(array[i]) + " is a repetition!");
                System.out.println("array[i] => " + array[i]);
            }
        }
    }

}
