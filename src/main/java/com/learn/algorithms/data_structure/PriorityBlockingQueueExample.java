package com.learn.algorithms.data_structure;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityBlockingQueue is a thread-safe, unbounded blocking queue
 * that uses the same ordering rules as PriorityQueue.
 * * It is commonly used in producer-consumer scenarios where tasks
 * need to be processed based on priority rather than arrival time.
 */


public class PriorityBlockingQueueExample {

    public static void priorityBlockingQueueExample() throws InterruptedException {
        // Unbounded priority queue, thread-safe
        PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<>();

        // Producer: Adding elements
        pbq.put(10);
        pbq.put(5);
        pbq.put(20);

        System.out.println("PriorityBlockingQueue initialized: " + pbq);

        /* * Consumer: take() is a blocking operation.
         * If the queue is empty, the thread will wait until an element becomes available.
         */
        System.out.println("Polling elements (in priority order):");
        while (!pbq.isEmpty()) {
            // take() blocks if empty, poll() returns null if empty
            Integer element = pbq.take();
            System.out.println("Processed: " + element);
        }
    }

    public static void main(String[] args) {
        System.out.println("===== PriorityBlockingQueue Example =====");
        try {
            priorityBlockingQueueExample();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted");
        }
    }
}