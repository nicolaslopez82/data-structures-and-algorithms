package com.nicolaslopez82.dsa.linkedlist.reversealinkedlistinplace;

public interface List<T extends Comparable<T>> {
    void reverse();
    void insert(T data);
    void remove(T data);
    void traverseList();
    int size();
}
