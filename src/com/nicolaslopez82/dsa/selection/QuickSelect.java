package com.nicolaslopez82.dsa.selection;

import java.util.Random;

/**
 * Selection algorithm is an algorithm for finding the k-th smallest/largest number in a list / array such a number
 * is called the k-th order statistic.
 *
 * It's use to find maximum, minimum or median.
 *
 * Works in O(N) time complexity.
 *
 * Methods: QuickSelect, median of medians methods.
 *
 * //=======================================//
 *
 * QuickSelect use 2 parts:
 * - Partition phase.
 * - Selection phase.
 *
 * If the use a good pivot on the QuickSelect algorithm, we are able to get rid of many items on every iteration.
 * Result => running time will be O(N) linear time complexity.
 *
 * The worst-case memory is O(logN).
 *
 * Good pivot is when the pivot is in the more middle item possible.
 *
 * With a good pivot, we're going to be able to discard half of the array in every iteration.
 */

public class QuickSelect {

    private int [] numbers;

    public QuickSelect(int[] numbers) {
        this.numbers = numbers;
    }

    public int select(int k){
        return select(0, numbers.length - 1, k - 1);
    }

    private int select(int startIndex, int lastIndex, int k) {

        int pivot = partition(startIndex, lastIndex);

        if(k < pivot){
            return select(startIndex, pivot - 1, k); //It on the left side.
        }
        else if(k > pivot){
            return select(pivot + 1, lastIndex, k); //It on the right side.
        }

        return numbers[k]; //It means that we have found the k-th item.
                           //This's how partition works: pivot == k.

    }

    private int partition(int startIndex, int lastIndex) {

        int pivot = new Random().nextInt(lastIndex - startIndex + 1) + startIndex;

        swap(lastIndex, pivot);

        for (int i = startIndex; i < lastIndex; ++i){
            if(numbers[i] > numbers[lastIndex]){ // If I want to find the smallest, I should change ">" for "<".
                swap(i, startIndex);
                startIndex++;
            }
        }

        swap(startIndex, lastIndex);

        return startIndex;
    }

    private void swap(int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
