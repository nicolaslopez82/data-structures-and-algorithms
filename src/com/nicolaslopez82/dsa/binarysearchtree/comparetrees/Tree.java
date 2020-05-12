package com.nicolaslopez82.dsa.binarysearchtree.comparetrees;

public interface Tree<T>{
    public Node<T> getRoot();
    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMaxValue();
    public T getMinValue();
}
