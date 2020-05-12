package com.nicolaslopez82.dsa.binaryheaps;

/**
 * PRIORITY QUEUES => (We uses with Heaps).
 *
 * - It is an abstract data type such as stack or queue.
 * - BUT every item has an additional property: a priority value.
 * - In a priority queue, an element with high priority is served before an element with lower priority.
 * - Priority queues are usually implemented with heaps, but it can be implemented with self balancing trees as well.
 * - Very similar to queues with some modification: when we would like to get the next item  the highest priority
 *   element is retrieved first !!!
 * - No FIFO structure here !!!
 *
 * ===============================================================================================================
 *
 * Heap Properties:
 *
 * 1) Complete -> We construct the heap from the left to the right across each row. The last row may not be completely full. There is not missing node from left to right in a layer.
 * 2) In a binary heap, every node can have 2 children, left child and right children.
 * 3) Min heap -> The parent is always smaller than the values of the children.
 *     Max heap -> the parent is always greater.
 *     The root node will be the smallest / greatest value in the heap. O(1) access!!
 *
 *  ===============================================================================================================
 *
 * - It is basically a binary tree.
 *
 * - 2 types -> Min & Max heap.
 *
 * - Max heaps -> The highest key is in the root node.
 *
 * - Min heaps -> The lowest key is in the root node.
 *
 * - Heaps is the maximally efficient implementation of a Priority Queue abstract data type.
 *
 *  ===============================================================================================================
 *
 * - Construct a heap -> O(N).
 *
 * - Reconstruct the heap -> O(N) + O(LogN) = O(N).
 *
 * - Inserting an item to the heap is just adding the data to the array with an incremented index.
 *
 * ===============================================================================================================
 *
 * Sorting Heaps:
 * - Sorting Heap Priority Queue -> O(N*logN) time complexity. The same that Quicksort and Mergesort
 *   algorithmic time complexity.
 *
 * ===============================================================================================================
 *
 * Binary Heaps -> Priority Queue:
 *
 * - It is an abstract data type such as stack and queue.
 *
 * - Every item has an additional property: a priority value.
 *
 * - Priority Queues are usually implemented with heaps, but it can be implemented with self-balancing trees as well.
 *
 * - Not FIFO structure here.
 */

public class Heap {

	private Integer[] heap;
	private int currentPosition =  -1;
	
	public Heap(int size){
		this.heap = new Integer[size];
	}

	public void insert(int item){
		
		if( isFull() ){
			throw new RuntimeException("Heap is full...");
		}
		
		this.heap[++currentPosition] = item;
		fixUp(currentPosition);
	}

	private void fixUp(int index) {
		int parentIndex = (index-1)/2;
		
		while( parentIndex >= 0 && this.heap[parentIndex] < this.heap[index] ){
			int temp = this.heap[index];
			this.heap[index]=this.heap[parentIndex];
			this.heap[parentIndex] = temp;
			index = parentIndex;
			parentIndex=(index-1)/2;
		}
	}
	
	// get root method
	public int getMax(){
		int result = this.heap[0];
		this.heap[0]=this.heap[currentPosition--];
		this.heap[currentPosition+1]=null; // avoid obsolete references
		fixDown(0,-1);
		return result;
	}
	
	public void heapsort() {
		for (int i=0; i <= currentPosition; i++) {
			int temp = this.heap[0]; // 
			System.out.print(temp+" ");
			this.heap[0] = this.heap[currentPosition-i];
			this.heap[currentPosition-i] = temp;
			fixDown(0, currentPosition-i-1);
		}
	}

	private void fixDown(int index, int upto) {
		if( upto < 0 ) upto = currentPosition;
		
		while( index <= upto ){
			int leftChild = 2*index+1;
			int rightChild = 2*index+2;
			
			if( leftChild <= upto ){
				int childToSwap;
				
				if( rightChild > upto ){
					childToSwap = leftChild;
				}else{
					childToSwap = ( this.heap[leftChild] > this.heap[rightChild]) ? leftChild : rightChild;
				}
				
				if( this.heap[index] < this.heap[childToSwap]){
					int temp = this.heap[index];
					this.heap[index]=this.heap[childToSwap];
					this.heap[childToSwap]=temp;
				}else{
					break;
				}
				
				index = childToSwap;
			}else{
				break;
			}
		}
	}

	private boolean isFull() {
		return this.currentPosition == this.heap.length;
	}
}
