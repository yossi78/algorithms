package com.learn.algorithms.data_structure;

import java.util.*;

public class GraphBFSExample {


    public static void GraphBFSExample() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(4));
        graph.put(4, new ArrayList<>());

        System.out.println("Graph: " + graph);

        // BFS traversal
        System.out.println("BFS Traversal:");

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int startNode = 1;
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Visited: " + node);

            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

    }



    public static void main(String[] args) {
        System.out.println("===== Graph BFS Example =====");
        GraphBFSExample();
    }
}












