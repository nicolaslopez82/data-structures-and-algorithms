package com.nicolaslopez82.dsa.searching.linearandbinarysearch;

public class LinearSearch <T> {

    private int array[];

    public LinearSearch(int[] array) {
        this.array = array;
    }

    public int linearSearch(int n){
        for (int i = 0; i < array.length; i++){
            if(n == array[i]) return i;
        }
        return -1;
    }
}
