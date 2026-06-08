package com.learn.algorithms.data_structure;

import java.util.*;

public class StackExample {


    // Demonstrates Stack (LIFO)
    public static void StackExample() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Print stack
        System.out.println("Stack: " + stack);

        // Peek (top element)
        System.out.println("Top element (peek): " + stack.peek());

        // Pop element
        System.out.println("Popped: " + stack.pop());

        // Print after pop
        System.out.println("Stack after pop: " + stack);

        // Search for element
        int searchValue = 2;
        if (stack.contains(searchValue)) {
            System.out.println("Stack contains: " + searchValue);
        }
    }





    public static void main(String[] args) {
        System.out.println("===== Stack Example =====");
        StackExample();


    }
}












