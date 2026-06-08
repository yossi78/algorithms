package com.learn.algorithms.data_structure;

import java.util.*;

public class PriorityQueueHeapExample {

    // Demonstrates Heap using PriorityQueue (Min Heap by default)
    public static void PriorityQueueHeapExample() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(1);
        pq.add(3);
        pq.add(2);

        // Print heap (not sorted view, internal structure)
        System.out.println("PriorityQueue: " + pq);

        // Peek (smallest element)
        System.out.println("Peek (min): " + pq.peek());

        // Remove elements (sorted order)
        System.out.println("Polling elements:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }


        // Max Heap (reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(3);
        System.out.println("Max Heap peek: " + maxHeap.peek());
    }



    public static void main(String[] args) {
        System.out.println("===== PriorityQueue (Heap) Example =====");
        PriorityQueueHeapExample();
    }
}












