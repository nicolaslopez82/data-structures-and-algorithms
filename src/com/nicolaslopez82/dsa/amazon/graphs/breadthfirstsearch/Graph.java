package com.nicolaslopez82.dsa.amazon.graphs.breadthfirstsearch;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Java program to print BFS traversal from a given source vertex.
 * BFS(int s) traverses vertices reachable from s.
 *
 * Note that the above code traverses only the vertices reachable from a given source vertex.
 * All the vertices may not be reachable from a given vertex (example Disconnected graph).
 * To print all the vertices, we can modify the BFS function to do traversal starting from all nodes one by one
 * (Like the DFS modified version. See src/com/nicolaslopez82/dsa/amazon/graphs/depthfirstsearch/Graph.java).
 *
 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
 */

public class Graph {

    //Number of Vertices/Nodes
    int totalVertices;

    //Adjacency Lists
    List<Integer> adjacency[];

    public Graph(int v) {
        this.totalVertices = v;
        this.adjacency = new LinkedList[v];
        for (int i = 0; i < this.totalVertices; i++){
            //In each adjacency[i] node, with instance a new list for all nodes/vertices related to adjacency[i]
            this.adjacency[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    public void add(int v, int w){
        this.adjacency[v].add(w);
    }

    /**
     * Prints BFS traversal from a given source s
     * @param s
     */
    public void BFSTraversal(int s){

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[this.totalVertices];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()){

            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.println(s);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = this.adjacency[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 2);
        graph.add(2, 0);
        graph.add(2,3);
        graph.add(3,3);

        graph.BFSTraversal(2);
    }
}
