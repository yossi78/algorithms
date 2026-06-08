package com.learn.algorithms.data_structure;

import java.util.*;

public class QueueExample {



    // Demonstrates Queue (FIFO)
    public static void QueueExample() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue: " + queue);

        // Peek (head element)
        System.out.println("Head element (peek): " + queue.peek());

        // Remove element
        System.out.println("Removed: " + queue.poll());

        // Print after removal
        System.out.println("Queue after poll: " + queue);

        // Search for element
        int searchValue = 2;
        if (queue.contains(searchValue)) {
            System.out.println("Queue contains: " + searchValue);
        }
    }



    public static void main(String[] args) {
        System.out.println("===== Queue Example =====");
        QueueExample();


    }
}












