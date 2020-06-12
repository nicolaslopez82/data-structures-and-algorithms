package com.nicolaslopez82.dsa.amazon.tree.traversals;

/**
 * @author nicolaslopez82
 */

public class BinaryTree {

    private Node root;
    private int sum = 0;

    public BinaryTree() {
        this.root = null;
    }

    private void printInOrderTraversal(Node node){

        if(null == node) return;

        printInOrderTraversal(node.getLeft());

        //The root node
        System.out.println(node.getData());

        sumatory(node.getData());

        printInOrderTraversal(node.getRight());

    }

    private void printPreOrderTraversal(Node node){

        if( null == node ) return;

        //The root node.
        System.out.println(node.getData());

        printPreOrderTraversal(node.getLeft());

        printPreOrderTraversal(node.getRight());
    }

    private void printPostOrderTraversal(Node node){

        if( null == node ) return;

        printPostOrderTraversal(node.getLeft());

        printPostOrderTraversal(node.getRight());

        //The root node.
        System.out.println(node.getData());
    }

    private void sumatory(int data){
        sum = sum * 10 + data;
        System.out.println("Counter: " + sum);
        System.out.println("\n-----------------------\n");
    }

    public void printInOrderTraversal(){
        printInOrderTraversal(root);
    }

    public void printPreOrderTraversal(){
        printPreOrderTraversal(root);
    }

    public void printPostOrderTraversal(){
        printPostOrderTraversal(root);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(1);
        binaryTree.root.setLeft(new Node(2));
        binaryTree.root.getLeft().setLeft(new Node(4));
        binaryTree.root.getLeft().setRight(new Node(5));
        binaryTree.root.setRight(new Node(3));

        System.out.println("\nInorder traversal of binary tree is ");
        binaryTree.printInOrderTraversal();

        System.out.println("Preorder traversal of binary tree is ");
        binaryTree.printPreOrderTraversal();

        System.out.println("\nPostorder traversal of binary tree is ");
        binaryTree.printPostOrderTraversal();
    }
}
