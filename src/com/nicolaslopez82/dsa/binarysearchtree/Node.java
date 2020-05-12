package com.nicolaslopez82.dsa.binarysearchtree;

public class Node<T> {

    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
