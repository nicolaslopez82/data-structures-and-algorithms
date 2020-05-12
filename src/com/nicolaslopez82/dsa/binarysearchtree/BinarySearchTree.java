package com.nicolaslopez82.dsa.binarysearchtree;

/**
 * - Binary search trees are data structures.
 *
 * - Keeps the keys in sorted order: So that lookup and other operations can use the principle of binary search!
 *
 * - Each comparison allows the operations to skip over half of the tree, so that each lookup/insertion/deletion
 *   takes time proportional to the logarithm of the number of items stored in the tree.
 *
 * - This is much better than the linear time O(N) required to find items by key in an unsorted array, but slower
 *   than the corresponding operations on hash tables.
 *
 * ===============================================================================================================
 *
 *   Insertion: we start at the root node. If the data we want to insert is greater than
 * 		the root node we go to the right, if it is smaller, we go to the left
 * 			And so on ...
 *
 * ===============================================================================================================
 *
 * 	Delete: soft delete  we do not remove the node from the BST we just
 * 	mark that it has been removed
 * 		~ not so efficient solution.
 *  In the main three possible cases:
 *
 * 		1.) The node we want to get rid of is a leaf node
 *
 * 		2.) The node we want to get rid of has a single child
 *
 * 		3.) The node we want to get rid of has 2 children
 *
 * ===============================================================================================================
 *
 * Traversal: sometimes it is neccessary to visit every node in the tree
 * 		We can do it several ways
 *
 * 			1.) In-order traversal -> leftSide + root +rightSide (recursively).
 *
 * 			2.) Pre-order traversal -> root + leftSide + rightSide (recursively).
 *
 * 			3.) Post-order traversal -> leftSide + rightSide + root (recursively).
 *
 * ===============================================================================================================
 *
 * 	What about the worst case scenarios?
 * 	- if the tree becomes unbalanced: the operations running times can be
 * 		reduced to O(N) in the worst case
 * 	- thats why it is important to keep a tree as balanced as possible
 *
 */

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> root;

    @Override
    public void insert(T data){
        if( root == null ){
            root = new Node<T>(data);
        }else {
            insertNode(data, root);
        }
    }


    @Override
    public void traversal() {

    }

    private void insertNode(T newData, Node<T> node) {

        if( newData.compareTo(node.getData()) < 0 ){
            if(node.getLeftNode() != null){
                insertNode(newData, node.getLeftNode());
            }else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftNode(newNode);
            }
        }else{
            if(node.getRightNode() != null){
                insertNode(newData, node.getRightNode());
            }else {
                Node<T> newNode = new Node<>(newData);
                node.setRightNode(newNode);
            }
        }

    }

    @Override
    public void delete(T data) {

    }

    @Override
    public T getMax() {
        if(this.root == null){
            return null;
        }
        return getMaxValue(root);
    }

    @Override
    public T getMin() {
        if(this.root == null){
            return null;
        }
        return getMinValue(this.root);
    }

    private T getMaxValue(Node<T> node) {
        if (node.getRightNode() != null) {
            return getMaxValue(node.getRightNode());
        }
        return node.getData();
    }

    private T getMinValue(Node<T> node) {
        if (node.getLeftNode() != null) {
            return getMinValue(node.getLeftNode());
        }
        return node.getData();
    }
}
