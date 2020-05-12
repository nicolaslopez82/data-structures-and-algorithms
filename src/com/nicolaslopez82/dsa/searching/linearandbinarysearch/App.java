package com.nicolaslopez82.dsa.searching.linearandbinarysearch;

public class App {

    public static void main(String[] args) {

        int [] nArray = {3, 4, 8, -2, 7, 12, 45, 28, 96, 72, 68, 101, -33, 90};

        LinearSearch linearSearch = new LinearSearch(nArray);
        System.out.println(linearSearch.linearSearch(96));

        BinarySearch binarySearch = new BinarySearch(nArray);
        System.out.println(binarySearch.binarySearch(0, nArray.length,28));
    }


}
