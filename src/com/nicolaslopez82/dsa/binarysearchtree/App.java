package com.nicolaslopez82.dsa.binarysearchtree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(1);
        tree.insert(-10);
        tree.insert(30);
        tree.insert(190);
        tree.insert(340);
        tree.insert(78);
        tree.insert(1530);
        tree.insert(56);
        tree.insert(1000);
        tree.insert(130);
        tree.insert(234);

        System.out.println("Get Max Value: " + tree.getMax());
        System.out.println("Get Min Value: " + tree.getMin());

    }
}
