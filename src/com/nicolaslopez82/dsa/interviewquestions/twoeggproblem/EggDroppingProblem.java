package com.nicolaslopez82.dsa.interviewquestions.twoeggproblem;

/**
 * The two eggs problem.
 *
 * The problem itself is that there are N number of eggs and building which has M floors.
 *
 * Write an algorithm to find the minimum number of drops is required to know the floor
 * from which if egg is dropped, it will break.
 *
 * (usually N=2 and M=100)
 */

public class EggDroppingProblem {

    //Dynamic programming table to store the values for the subproblems
    ///dpTable[i][j] represents the minimum number of drops with i eggs and j floors.
    private int[][] dpTable = new int[Constants.NUM_OF_EGGS + 1][Constants.NUM_OF_FLOORS + 1];

    public int solve(){

        //The first column is initialized with 1s:
        dpTable[0][0] = 1;
        dpTable[1][0] = 1;

        //Linear search basically
        for(int i = 0; i <= Constants.NUM_OF_FLOORS; i++){
            dpTable[1][i] = i;
        }

        //i is the index for the eggs - j is the index for the floors.
        for(int n = 2; n <= Constants.NUM_OF_EGGS; n++){
            for(int m = 1; m <= Constants.NUM_OF_FLOORS; m++){
                dpTable[n][m] = Integer.MAX_VALUE;

                //Check dropping the egg from 1 to the current floor j.
                //NOTE: WE CAN REUSE THE SUBSOLUTIONS FROM THE TABLE!!!
                for(int x = 1; x <= m; x++){

                    //we hace to use the formula we have already discussed +
                    //user max because of worst-case scenario.
                    //Don't forget to add one to include the current drop.
                    int maxDrops = 1 + Math.max(dpTable[n-1][x-1], dpTable[n][m-x]);

                    //This is taking the minimum (because we are after the minimum number of drops)
                    if(maxDrops < dpTable[n][m]){
                        dpTable[n][m] = maxDrops;
                    }
                }
            }
        }

        //The last item in the table contains the minimum number of drops.
        return dpTable[Constants.NUM_OF_EGGS][Constants.NUM_OF_FLOORS];
    }
}
