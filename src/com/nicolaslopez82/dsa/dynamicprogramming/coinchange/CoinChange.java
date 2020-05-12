package com.nicolaslopez82.dsa.dynamicprogramming.coinchange;

/**
 * Coin Change Problem
 *
 * - Given a set of coins v[] for example {1,2,3}.
 * - Given an M amount  the total.
 * - How many ways the coins v[] can be combined in order to get the total M?.
 * - The order of coins does not matter !!!
 * - This is the coin change problem.
 *
 * //=========================================================================//
 *
 * - Coins v[]  {1, 2, 3}.
 *
 * - Total amount M  4
 *
 * - Solution to the coin change problem:
 *   {1,1,1,1} {1,1,2} {1,3} {2,2}
 *
 * - The order of coins does not matter !!!
 *  	For exmple {1,3} = {3,1}
 *
 *  //=========================================================================//
 *
 *  Resolution with Dynamic Programming:
 *
 *  - We have to create a solution matrix:
 *
 *        dpTable[numOfCoins+1][totalAmount+1]
 * 	              rows                      columns
 *
 *  - We have to define the base cases:
 * 	    - if totalAmount is 0  there is 1 way to make the change
 * 		    Because we do not include any coin !!!
 *
 * 	    - if numOfCoins is 0  there is 0 way to change the amount
 * 		    In this case there is no solution !!!
 *
 * - Complexity: O(v*M)
 *
 * - For every coin: make a decision whether to include it or not.
 *
 * - Check if the coin value is less than or equal to the amount needed:
 *
 *   If yes   then we will find ways by including that coin and excluding that coin
 * 	    1.) include the coin: reduce the amount by coin value and use
 * 		    the subproblem solution // totalAmount – v[i].
 * 	    2.) exclude the coin: solution for the same amount with­out
 * 		    considering that coin.
 *
 * //=========================================================================//
 *
 *   M = 4				numOfColumns = M+1
 *   v[] = {1,2,3}		numOfRows = v.length+1
 *
 * - Subproblems: we consider the totals {0,1,2,3,4} step by step when we can have {0,1,2,3}
 *   coins at the same time !!! We solve the subproblems and combine them for the final solution
 */

public class CoinChange {

    //Recursive Coin Change - Exponential running time O(2^N).
    public int naiveCoinChange(int M, int[] v, int index) {
        if( M < 0 ) return 0;
        if( M == 0 ) return 1;

        if( v.length == index ){  //At this point we've been considering every single coin. All the coins.
            return 0;
        }

        return naiveCoinChange( M - v[index], v, index) + //We take the given coin with the given index.
                naiveCoinChange(M, v, index + 1 ); //We don't take the given coin with the given index and we have to considering the next one.

    }

    public void dynamicProgrammingCoinChange(int[] v, int M){

        int[][] dpTable = new int [v.length + 1][M + 1];

        //Initialize the first column.
        for(int i = 0; i <= v.length; i++){
            dpTable [i][0] = 1;
        }

        //Initialize the first row.
        for(int i = 1; i <= M; i++){
            dpTable [0][i] = 0;
        }

        // O(v * M)
        //Go through the matrix.
        for(int i = 1; i <= v.length; i++){
            for(int j = 1; j <= M; j++){

                // v[i-1] means -> value of the given coin.
                if(v[i-1] <= j){
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-v[i-1]]; //We take the given coin with the given index.
                }else{
                    dpTable[i][j] = dpTable[i-1][j]; //We don't take the given coin with the given index and we have to considering the next one.
                }
            }
        }
        System.out.println("Solution: " + dpTable[v.length][M]);
    }

}
