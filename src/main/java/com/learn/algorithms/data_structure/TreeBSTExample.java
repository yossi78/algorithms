package com.learn.algorithms.data_structure;

import java.util.*;

public class TreeBSTExample {



    public static void TreeBSTExample() {
        // TreeSet (sorted, no duplicates)
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1); // duplicate (ignored)

        System.out.println("TreeSet (sorted): " + treeSet);

        // Search
        int searchValue = 3;
        if (treeSet.contains(searchValue)) {
            System.out.println("TreeSet contains: " + searchValue);
        }

        // First and last (min / max)
        System.out.println("Min: " + treeSet.first());
        System.out.println("Max: " + treeSet.last());

        // TreeMap (key-value, sorted by keys)
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "Cherry");
        treeMap.put(1, "Apple");
        treeMap.put(2, "Banana");

        System.out.println("TreeMap (sorted by keys): " + treeMap);






        // Iterate
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Search by key
        int key = 2;
        if (treeMap.containsKey(key)) {
            System.out.println("Found key " + key + ": " + treeMap.get(key));
        }

        System.out.println();
    }






    public static void main(String[] args) {
        System.out.println("===== Tree (BST) Example =====");
        TreeBSTExample();


    }
}












