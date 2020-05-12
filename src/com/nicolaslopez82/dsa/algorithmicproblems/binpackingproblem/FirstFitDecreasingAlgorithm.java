package com.nicolaslopez82.dsa.algorithmicproblems.binpackingproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *   BIN PACKING PROBLEM
 *
 * - Objects of different volumes must be packed into a finite number of bins or
 *   containers each of volume V in a way that minimizes the number of bins used.
 *
 * - In the main: how to fit several things into containers in an efficient way.
 * - It is an NP-complete problem.
 * - When the number of bins is restricted to 1 and each item is characterised
 *   by both a volume and a value, the problem of maximising the value of items
 *   that can fit in the bin is known as the knapsack problem
 *
 *   1.) Naive approach „brute force search”
 *       - Iterate over all bins, try to put the current item in the bin and
 *         ( if it fits ) call the same method with the next item.
 *
 *   2.) First-fit algorithm
 *       - Iterate over all the items we want to put into bins  if we are not
 *         able to put it into a given bin we try to put it into the next one.
 *
 *       - Yields non-optimal solutions in the main.
 *
 *    3.) First-fit decreasing algorithm. => We're going to be use it.
 *       - Sorting the items in decreasing order may be helpful.
 *         After sorting we use first-fit algorithm.
 *
 *       - Yields non-optimal solutions in the main.
 *
 * //=============================================================================================//
 *
 * Applications:
 *
 * - We have N groups of people with group sizes w1, w2 ... wN. We have minibuses with capacity C.
 *   What is the optimal number of minibuses when the groups must stay together?
 *
 * - Virtual machines often have to solve this problem.
 *
 * - Television advertisements: we are given a certain time slot (for example 10 minutes).
 *   How do we pack the the most commercials into each time slot and maximize our daily profits?
 *
 */

public class FirstFitDecreasingAlgorithm {

	private List<Bin> bins ;
	private List<Integer> items;
	private int binCapacity;
	private int binCounter = 1;

    public FirstFitDecreasingAlgorithm(List<Integer> items, int binCapacity) {
        this.items = items;
        this.binCapacity = binCapacity;
        this.bins = new ArrayList<>(this.items.size());
    }

    public void solveBinPackingProblem() {
       
    	Collections.sort(this.items, Collections.reverseOrder());
    
    	if( this.items.get(0) > this.binCapacity ){
    		System.out.println("No feasible solution...");
    		return;
    	}
    	
    	this.bins.add(new Bin(binCapacity,binCounter));  // first bin !!!
        
    	for (Integer currentItem : items) {
           
            boolean isOk = false; // track whether we have put the item into a bin or not
            int currentBin = 0;
            
            while (!isOk) {
                if (currentBin == this.bins.size()) {  // item does not fit in last bin -> try a new bin
                    Bin newBin = new Bin(binCapacity,++binCounter);
                    newBin.put(currentItem);
                    this.bins.add(newBin);
                    isOk = true;
                } else if (this.bins.get(currentBin).put(currentItem)) {  // current item fits in the given bin
                    isOk = true;
                } else {                
                    currentBin++;  // trying the next bin
                }
            }
        }
    }
    
    public void showResults(){
    	for(Bin bin : this.bins){
    		System.out.println(bin);
    	}
    }
}
