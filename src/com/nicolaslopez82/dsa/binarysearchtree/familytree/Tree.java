package com.nicolaslopez82.dsa.binarysearchtree.familytree;

public interface Tree<T> {
    public int getAgesSum();
    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMaxValue();
    public T getMinValue();
}