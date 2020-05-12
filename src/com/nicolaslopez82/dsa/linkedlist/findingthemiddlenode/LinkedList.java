package com.nicolaslopez82.dsa.linkedlist.findingthemiddlenode;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int size;

    public LinkedList() {}

    @Override
    public Node<T> getMiddleNode() {

        Node<T> slowNode = this.root;
        Node<T> fastNode = this.root;

        while (fastNode.getNextNode() != null && fastNode.getNextNode().getNextNode() != null){
            fastNode = fastNode.getNextNode().getNextNode();
            slowNode = slowNode.getNextNode();
        }
        return slowNode;
    }

    @Override
    public void insert(T data) {

        ++this.size;

        if (this.root == null) {
            this.root = new Node(data);
        } else {
            insertDataBeginnig(data);
        }

    }

    @Override
    public void remove(T data) {

        if (this.root == null) {
            return;
        }

        --this.size;

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    @Override
    public void traverseList() {
        if (this.root == null) {
            return;
        }

        Node<T> node = this.root;
        while (node != null) {
            System.out.println(node + " ");
            node.getNextNode();
        }
    }

    @Override
    public int size() {
        return this.size();
    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode != null) {

            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    //O(1) Constant time complexity, just update the references.
    private void insertDataBeginnig(T data) {

        Node newNode = new Node(data);
        newNode.setNextNode(this.root);
        this.root = newNode;

    }

    //O(1) Constant time complexity, just update the references at the end.
    private void insertDataEnd(T data, Node<T> node) {

        if (node.getNextNode() != null) {
            insertDataEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }

    }
}
