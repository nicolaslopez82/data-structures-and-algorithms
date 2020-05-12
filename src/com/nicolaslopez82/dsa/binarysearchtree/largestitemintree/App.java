package com.nicolaslopez82.dsa.binarysearchtree.largestitemintree;

/**
 * k-th smallest element in a search tree overview
 * Interview Question #2:
 *
 * Write an efficient in-place algorithm to find the k-th smallest (largest) item in a binary search tree!
 */

public class App {

    public static void main(String[] args) {

        Tree<Integer> bst = new BinarySearchTree<>();

        bst.insert(5);
        bst.insert(27);
        bst.insert(37);
        bst.insert(62);
        bst.insert(9);

        System.out.println(bst.getKSmallest(bst.getRoot(),3));

    }
}
