package com.nicolaslopez82.dsa.linkedlist.findingthemiddlenode;

public interface List <T extends Comparable<T>> {

    Node<T> getMiddleNode();
    void insert(T data);
    void remove(T data);
    void traverseList();
    int size();
}
