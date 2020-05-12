package com.nicolaslopez82.dsa.dynamicprogramming.knapsack;

public class Knapsack {

	private int numOfItems;
	private int capacityOfKnapsack;
	private int[][] knapsackTable;
	private int totalBenefit;
	private int[] weights;
	private int[] values;
	
	public Knapsack(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
		this.numOfItems = numOfItems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.weights = weights;
		this.values = values;
		this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack+1];
	}
	
	public void solve() {
		
		// time complexity: O(N*W)
		for(int i=1;i<numOfItems+1;i++) {
			for(int w=1;w<capacityOfKnapsack+1;w++) {
				
				int notTakingItem = knapsackTable[i-1][w]; // not taking item i
				int takingItem = 0;
				
				if( weights[i] <= w ) {
					takingItem = values[i] + knapsackTable[i-1][w-weights[i]]; 
				}
				
				knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
			}
		}
		
		totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
	}
	
	public void showResult() {
		
		System.out.println("Total benefit: " + totalBenefit);
		
		for(int n=numOfItems, w = capacityOfKnapsack;n>0;n--) {
			if( knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w] ) {
				System.out.println("We take item: #"+n);
				w = w - weights[n];
			}
		}
	}
}
