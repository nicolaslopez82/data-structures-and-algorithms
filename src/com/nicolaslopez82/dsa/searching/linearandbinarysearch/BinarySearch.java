package com.nicolaslopez82.dsa.searching.linearandbinarysearch;

public class BinarySearch<T extends Comparable<T>> {

    private int nArray[];

    public BinarySearch(int[] nArray) {
        this.nArray = nArray;
    }

    public int binarySearch(int startIndex, int endIndex, int item){

        if(endIndex < startIndex){
            System.out.println("The item is not present in the array.");
            return -1;
        }

        int middleIndex = nArray.length / 2;

        if(item == nArray[middleIndex]){
            return middleIndex;
        }else if(item < nArray[middleIndex]){
            return binarySearch(startIndex, middleIndex -1, item);
        }else{
            return binarySearch(middleIndex + 1, endIndex, item);
        }
    }
}
