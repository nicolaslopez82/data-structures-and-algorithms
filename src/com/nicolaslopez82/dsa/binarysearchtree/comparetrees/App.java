package com.nicolaslopez82.dsa.binarysearchtree.comparetrees;

/**
 * Compare binary trees overview
 * Interview Question #1:
 *
 * Write an efficient algorithm thats able to compare two binary search trees.
 * The method returns true if the trees are identical
 * (same topology with same values in the nodes) otherwise it returns false.
 */

public class App {

    public static void main(String[] args) {

        Tree<Integer> bst1 = new BinarySearchTree<>();

        bst1.insert(3);
        bst1.insert(57);
        bst1.insert(87);
        bst1.insert(22);
        bst1.insert(9);

//        bst1.insert(2);
//        bst1.insert(26);
//        bst1.insert(37);
//        bst1.insert(76);
//        bst1.insert(9);

        Tree<Integer> bst2 = new BinarySearchTree<>();

        bst2.insert(2);
        bst2.insert(26);
        bst2.insert(37);
        bst2.insert(76);
        bst2.insert(9);


        TreeCompareHelper<Integer> helper = new TreeCompareHelper<>();
        System.out.println(helper.compareTrees(bst1.getRoot(), bst2.getRoot()));
    }
}
