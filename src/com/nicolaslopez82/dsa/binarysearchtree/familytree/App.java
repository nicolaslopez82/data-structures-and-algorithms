package com.nicolaslopez82.dsa.binarysearchtree.familytree;

/**
 * Family age problem overview
 * Interview Question #3:
 *
 * Write an efficient algorithm to calculate the total sum of ages in a family tree.
 * A family tree is a binary search tree in this case where all the nodes contain
 * a Person object with [name,age] attributes.
 *
 * Hint: we have to make a tree traversal so the running time of
 * the algoritm will be O(N) linear running time
 */

public class App {

    public static void main(String[] args) {


        // O(N)   OR  O(logN)
        Tree<Person> bst = new BinarySearchTree<>();

        bst.insert(new Person("Nicolas",37));
        bst.insert(new Person("Belkis",63));
        bst.insert(new Person("Hugo",68));
        bst.insert(new Person("Sabrina",35));
        bst.insert(new Person("Bianca",4));
        bst.insert(new Person("Daniela",39));
        bst.insert(new Person("Thiago",15));
        bst.insert(new Person("Damix",37));

        System.out.println(bst.getAgesSum());


    }
}
