package com.learn.algorithms.data_structure;

import java.util.*;

public class DequeExample {




    public static void DequeExample() {
        Deque<Integer> deque = new ArrayDeque<>();

        // Add elements to both ends
        deque.addFirst(1); // front
        deque.addLast(2);  // back
        deque.addFirst(0);

        System.out.println("Deque: " + deque);

        // Peek elements
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        // Remove elements from both ends
        System.out.println("Removed first: " + deque.pollFirst());
        System.out.println("Removed last: " + deque.pollLast());

        System.out.println("Deque after removals: " + deque);

        // Search
        int searchValue = 2;
        if (deque.contains(searchValue)) {
            System.out.println("Deque contains: " + searchValue);
        }

        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("===== Deque Example =====");
        DequeExample();

    }
}












