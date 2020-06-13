package com.nicolaslopez82.dsa.amazon.graphs.depthfirstsearch;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Complexity Analysis:
 * Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
 * Space Complexity: O(V).
 * Since, an extra visited array is needed of size V.
 */
public class Graph {

    //Total Vertices/Nodes.
    int V;

    // Array of lists for Adjacency List Representation
    List<Integer> adjacency[];

    // Constructor
    public Graph(int v) {
        this.V = v;
        this.adjacency = new LinkedList[V];
        for (int i = 0; i < V; i++){
            //In each adjacency[i] node, with instance a new list for all nodes/vertices related to adjacency[i].
            this.adjacency[i] = new LinkedList<>();
        }
    }

    /**
     * Function to add an edge into the graph
     * @param v -> Vertice
     * @param w -> Node adjacency to Vertice
     */
    public void addEdge(int v, int w){
        this.adjacency[v].add(w);
    }

    /**
     * The function to do DFS traversal. It uses recursive DFSUtil()
     * @param v
     */
    public void DFSTraversal(int v){

        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[this.V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    /**
     * A function used by DFSTraversal
     * @param v
     * @param visited
     */
    private void DFSUtil(int v, boolean[] visited) {

        // Mark the current node as visited and print it.
        visited[v] = true;
        System.out.println(v + " ");

        // Recursion for all the vertices adjacent to this vertex.
        Iterator<Integer> iterator = this.adjacency[v].listIterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFSTraversal(2);
    }
}
