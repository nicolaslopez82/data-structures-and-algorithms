package com.nicolaslopez82.dsa.dynamicprogramming.coinchange;

public class App {
    public static void main(String[] args) {

        int [] v = {1,2,3};
        int M = 4;

        CoinChange coinChange = new CoinChange();

        //With Naive Approach -> Exponential running time: O(2^N).
        System.out.println(coinChange.naiveCoinChange(M, v, 0));

        //With Dynamic Programming -> Running time complexity: O(v*M).
        coinChange.dynamicProgrammingCoinChange(v, M);

    }
}
