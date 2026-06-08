package com.learn.algorithms.data_structure;


import java.util.*;

public class ListExample {

    public static void ListExample() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Apple"); // duplicate allowed
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index: " + i + ", Value: " + list.get(i));
        }
        int index = 2;
        if (index < list.size()) {
            System.out.println("Item at index " + index + ": " + list.get(index));
        }
        // Search by value
        String searchValue = "Banana";
        if (list.contains(searchValue)) {
            System.out.println("List contains: " + searchValue);
        }
        // Find index of a value
        System.out.println("Index of 'Apple': " + list.indexOf("Apple"));
        System.out.println();
    }





    public static void main(String[] args) {
        System.out.println("===== List Example =====");
        ListExample();

    }
}












