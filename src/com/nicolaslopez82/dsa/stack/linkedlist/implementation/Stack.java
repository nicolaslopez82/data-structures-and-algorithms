package com.nicolaslopez82.dsa.stack.linkedlist.implementation;

/**
 * Stack implementation with LinkedList.
 *
 * It is an abstract data type (interface).
 * Basic operations: pop(), push() and peek().
 * LIFO structure: last in first out.
 *
 * - Most important application of stacks: stack memory.
 * - It is a special region of the memory (in the RAM).
 * - A call stack is an abstract data type that stores information about the active subroutines / methods / functions of a computer program.
 * - The details are normally hidden and automatic in high-level programming languages.
 *
 * - Why is it good?
 *   - It keeps track of the point to which each active subroutine should return control when it finishes executing.
 *   - Stores temporary variables created by each function.
 *
 * ====================================================================================================================
 *
 * Heap Memory:
 * - The heap is a region of memory that is not managed automatically for you.
 * - This is a large region of memory // unlike stack memory.
 * - C: malloc() and calloc() function // with pointers.
 * - Java: reference types and objects are on the heap.
 * - We have to deallocate these memory chunks: because it is not managed automatically.
 * - If not: memory leak !!!
 * - Slower because of the pointers.
 *
 * ====================================================================================================================
 *
 * Stacks and Recursion:
 * - There are several situations when recursive methods are quite handy.
 * - For example: DFS, traversing a binary search tree, looking for an item in a linked list ...
 * - What’s happening in the background?
 *      - All the recursive algorithms can be transformed into a simple method with stacks.
 * - IMPORTANT: if we use recursion, the OS will use stacks anyways !!!
 *
 * @param <T>
 */

public class Stack <T extends Comparable<T>> {

    private Node<T> root;
    private int count;

    //O(1) Constant Time Complexity
    public void push(T data){
        this.count++;
        if(this.root == null){
            Node newNode = new Node(data);
            this.root = newNode;
        }else {
            Node<T> oldNode = this.root;
            this.root = new Node<>(data);
            this.root.setNextNode(oldNode);
        }
    }

    //O(1) Constant Time Complexity
    public T pop(){
        T dataToPop = this.root.getData();
        this.root = this.root.getNextNode();
        this.count--;
        return dataToPop;
    }

    public T peek(T node){
        return this.root.getData();
    }

    // O(1) constant time
    public boolean isEmpty(){
        return this.root == null;
    }

    //O(1) Constant Time Complexity
    public int size(){
        return this.count;
    }

}
