package com.learn.algorithms.data_structure;

import java.util.*;

public class HashMapExample {


    public static void HashMapExample() {
        System.out.println("=== HashMap Example ===");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        // Search by key
        int searchKey = 2;
        if (map.containsKey(searchKey)) {
            System.out.println("Found by key " + searchKey + ": " + map.get(searchKey));
        }
        // Search by value
        String searchValue = "Cherry";
        if (map.containsValue(searchValue)) {
            System.out.println("Found value: " + searchValue);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("===== HashMap Example =====");
        HashMapExample();

    }
}












