package com.learn.algorithms.data_structure;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class ConcurrentHashMapExample {

    public static void demonstrateConcurrentHashMap() {
        // 1. Initialization
        // It implements the ConcurrentMap interface, ensuring thread-safe operations
        ConcurrentHashMap<String, Integer> stockMap = new ConcurrentHashMap<>();
        stockMap.put("Apple", 100);
        stockMap.put("Banana", 150);
        stockMap.put("Cherry", 200);

        // 2. Thread-Safe Atomic Operation: putIfAbsent
        // It only inserts if the key doesn't exist, entirely thread-safe
        stockMap.putIfAbsent("Apple", 500); // Won't change Apple's value because it already exists
        stockMap.putIfAbsent("Date", 300);  // Will be added

        // 3. Simulating Multi-threaded Access
        // We will spin up a pool of 3 threads to update stock simultaneously
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable updateTask = () -> {
            for (int i = 0; i < 50; i++) {
                // computeIfPresent is atomic. It safely updates the value for a key.
                stockMap.computeIfPresent("Apple", (key, value) -> value + 1);
            }
        };

        // Submit the task to 3 different threads concurrently
        executor.submit(updateTask);
        executor.submit(updateTask);
        executor.submit(updateTask);

        // Shut down the executor and wait for threads to finish
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 4. Iterating safely
        // ConcurrentHashMap allows safe iteration even if other threads are modifying it
        for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Stock: " + entry.getValue());
        }

        // 5. Search Operations
        String searchKey = "Banana";
        if (stockMap.containsKey(searchKey)) {
            System.out.println("\nFound key '" + searchKey + "' with stock: " + stockMap.get(searchKey));
        }
    }

    public static void main(String[] args) {
        System.out.println("===== ConcurrentHashMap Example =====");
        demonstrateConcurrentHashMap();
    }
}