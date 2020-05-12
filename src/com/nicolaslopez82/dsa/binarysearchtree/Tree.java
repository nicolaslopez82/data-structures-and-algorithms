package com.nicolaslopez82.dsa.binarysearchtree;

public interface Tree<T> {

    void traversal();

    void insert(T data);

    void delete(T data);

    T getMax();

    T getMin();
}
