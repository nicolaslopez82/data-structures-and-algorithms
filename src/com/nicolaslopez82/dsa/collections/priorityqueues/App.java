package com.nicolaslopez82.dsa.collections.priorityqueues;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PRIORITY QUEUES => (We uses with Heaps).
 *
 * - It is an abstract data type such as stack or queue.
 * - BUT every item has an additional property: a priority value.
 * - In a priority queue, an element with high priority is served before an element with lower priority.
 * - Priority queues are usually implemented with heaps, but it can be implemented with self balancing trees as well.
 * - Very similar to queues with some modification: when we would like to get the next item  the highest priority
 *   element is retrieved first !!!
 * - No FIFO structure here !!!
 */

public class App {

    public static void main(String[] args) {

        // primitive types
//        Queue<String> pQueue = new PriorityQueue<>();
//
//        pQueue.add("F");
//        pQueue.add("C");
//        pQueue.add("Z");
//        pQueue.add("A");
//
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());

        // custom objects
        Queue<Person> queue = new PriorityQueue<>();
        queue.add(new Person("Balazs", 55));
        queue.add(new Person("Adam", -1));
        queue.add(new Person("Joe", 123));
        queue.add(new Person("Agi", 37));
        
        // O(logN)

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
