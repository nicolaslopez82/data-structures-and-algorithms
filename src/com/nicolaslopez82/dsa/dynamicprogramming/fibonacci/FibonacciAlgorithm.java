package com.nicolaslopez82.dsa.dynamicprogramming.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci sequence: 0  1  1  2  3  5  8  13  21  34 ...
 *
 * Fibonacci numbers are defined
 *  by the recurrence relation
 *  F(N) = F(N-1) + F(N-2)
 * F(0) = 0   F(1) = 1
 *
 * With generator functions we can get a closed form: "Binet formula”
 *
 * What is the problem with the recursive formula? We calculate same
 * problems over and over again
 *
 * 			f(n) = f(n-1) + f(n-2)
 *
 * //======================================================================//
 *
 * - Solution: use dynamic programming and memoization in order to avoid
 *    recalculating a subproblem over and over again.
 *
 * - We should use an associative array abstract data type (hashtable) to store
 *   the solution for the subproblems // O(1) time complexity.
 *
 * - On every f() method call  we insert the calculated value if necessary.
 *
 * - Why is it good? Instead of the exponential time complexity we will have
 *   O(N) time complexity + requires O(N) space.
 *
 */


public class FibonacciAlgorithm {

	private Map<Integer, Integer> memoizeTable; // O(1)
	
	public FibonacciAlgorithm(){
		this.memoizeTable = new HashMap<>();
		this.memoizeTable.put(0, 0);
		this.memoizeTable.put(1, 1);
	}
	
	public int fibonacciMemoize(int n){
		
		if( this.memoizeTable.containsKey(n) ) return this.memoizeTable.get(n);
		
		this.memoizeTable.put(n-1, fibonacciMemoize(n-1));
		this.memoizeTable.put(n-2, fibonacciMemoize(n-2));
		
		int calculatedNumber = this.memoizeTable.get(n-1) + this.memoizeTable.get(n-2);
		this.memoizeTable.put(n, calculatedNumber);
		
		return calculatedNumber;
		
	}
	
	public int naiveFibonacci(int n){
		
		if( n == 0 ) return 0;
		if( n == 1 ) return 1;
		
		return (naiveFibonacci(n-1) + naiveFibonacci(n-2));	
	}
}
