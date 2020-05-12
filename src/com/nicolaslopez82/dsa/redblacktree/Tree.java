package com.nicolaslopez82.dsa.redblacktree;

public interface Tree {
    public Node getMax();
    public Node getMin();
    public void insert(int data);
    public void remove(int value);
    public void traverseGraph();
}
