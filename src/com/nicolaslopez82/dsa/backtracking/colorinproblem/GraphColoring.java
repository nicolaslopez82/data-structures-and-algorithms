package com.nicolaslopez82.dsa.backtracking.colorinproblem;

public class GraphColoring {
	
	private int numOfVertices;
	private int numOfColors;
	private int[] colors;
	private int[][] graphMatrix;

	public void graphColor(int[][] graph, int numOfColors) {
		this.numOfVertices = graph.length;
		this.numOfColors = numOfColors;
		this.colors = new int[numOfVertices];
		this.graphMatrix = graph;
	}

	public void solveColoringProblem() {
		
		if(	solve(0) ) {
			showResult();
		} else {
			
			System.out.println("No solution with the given parameters...");
		} 
	}

	public boolean solve(int nodeIndex) {

		//if we find a color to the last node: the problem is solved
		//this is the base case for recursion
		if (nodeIndex == numOfVertices) {
			return true;
		}

		//try all colors (color indexes starts with 1)
		for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
			
			//try to assign the color to the node
			if (isColorValid(nodeIndex, colorIndex)) {
				//assign and proceed with next vertex (node)
				colors[nodeIndex] = colorIndex;
				
				//if we can solve the problem for the next node
				//then we return true
				if( solve(nodeIndex + 1) )
					return true;
				
				//otherwise BACKTRACK so increment the color index
			}
		}
		
		//no solution because we tried all the colors without any result
		return false;
	}

	public boolean isColorValid(int nodeInex, int colorInedex) {
		
		//check the nodes
		for (int i = 0; i < numOfVertices; i++) {
			//if the adjacent node has the same color then return false
			if (graphMatrix[nodeInex][i] == 1 && colorInedex == colors[i]) {
				return false;
			}
		}

		//the given color is valid for the node
		return true;
	}

	public void showResult() {
		for (int i = 0; i < numOfVertices; i++)
			System.out.println("Node " + (i + 1) + " has color index: " + colors[i] + " ");
		System.out.println();

	}
}
