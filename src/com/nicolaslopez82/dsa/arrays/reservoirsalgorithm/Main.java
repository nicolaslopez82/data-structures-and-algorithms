package com.nicolaslopez82.dsa.arrays.reservoirsalgorithm;

public class Main {



    public static void main(String[] args) {

        int[] nums = {13,28,5,99,45,73,85,95,63,42,78,55,21,11,46,59,83,82,47,51,50,63,98,90,70,81,29,57,17,89};
        int k = 5;

        ReservoirAlgorithm reservoirAlgorithm = new ReservoirAlgorithm();
        reservoirAlgorithm.reservoirAlgorithmSolve(nums, k);
    }
}
