package com.nicolaslopez82.dsa.linkedlist.implementation;

import java.util.StringJoiner;

public class Node <T extends Comparable<T>>{

    private Node<T> nextNode;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("data = " + data)
                .add("nextNode = " + nextNode)
                .toString();
    }
}
