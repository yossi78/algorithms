package com.learn.algorithms.data_structure;

import java.util.*;

public class SetExample {



    public static void SetExample() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // duplicate
        // Print all items
        for (Integer num : set) {
            System.out.println(num);
        }
        // Search by value
        int searchValue = 2;
        if (set.contains(searchValue)) {
            System.out.println("Set contains: " + searchValue);
        }
        // NOTE: Set has no index, but we can simulate it
        int index = 1;
        int i = 0;
        for (Integer num : set) {
            if (i == index) {
                System.out.println("Item at index " + index + ": " + num);
                break;
            }
            i++;
        }
        System.out.println();
    }







    public static void main(String[] args) {
        System.out.println("===== Set Example =====");
        SetExample();


    }
}












