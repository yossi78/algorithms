package com.learn.algorithms.data_structure;

import java.util.*;

public class LinkedListExample {





    public static void LinkedListExample() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Add at first and last
        list.addFirst("First");
        list.addLast("Last");

        // Print list
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index: " + i + ", Value: " + list.get(i));
        }

        // Get first and last
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Remove element
        list.remove("Banana");
        System.out.println("After removing 'Banana': " + list);

        // Search
        String searchValue = "Cherry";
        if (list.contains(searchValue)) {
            System.out.println("List contains: " + searchValue);
        }
    }





    public static void main(String[] args) {
        System.out.println("===== LinkedList Example =====");
        LinkedListExample();

    }
}












