package com.nicolaslopez82.dsa.stack.array.implementation;

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
 * @param <Item>
 */
public class Stack<Item>  {

    private Item[] stack;
    private int numberOfItems;

    public Stack(){
        this.stack = ( Item[] ) new Object[1];
    }

    public void push(Item item){

        if( numberOfItems == this.stack.length ){
            resize(2*this.stack.length);
        }

        this.stack[numberOfItems++] = item;
    }

    public Item pop(){
        Item itemToPop = this.stack[--numberOfItems];

        if( numberOfItems > 0 && numberOfItems == this.stack.length/4 ){
            resize(this.stack.length/2);
        }

        return itemToPop;
    }

    public boolean isEmpty(){
        return this.numberOfItems == 0;
    }

    public int size(){
        return this.numberOfItems;
    }

    // O(n)
    private void resize(int capacity) {

        Item[] stackCopy = ( Item[] ) new Object[capacity];

        for(int i=0;i<numberOfItems;i++){
            stackCopy[i]=this.stack[i];
        }

        this.stack = stackCopy;
    }

}
