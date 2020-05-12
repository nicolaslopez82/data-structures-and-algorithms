package com.nicolaslopez82.dsa.arrays.reversingarrayinplace;

public class Main {

    public static void main(String[] args) {

        int[] nArray = {1,2,3,4,5};

        ReverseArray reverseArray = new ReverseArray();

        int[] arrayReversed = reverseArray.reverseArray(nArray);

        for (int i=0; i<arrayReversed.length; i++){
            System.out.println(arrayReversed[i]);
        }
    }

}
