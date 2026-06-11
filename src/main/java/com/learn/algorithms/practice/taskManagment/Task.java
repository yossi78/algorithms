package com.learn.algorithms.practice.taskManagment;


import java.time.Instant;

class Task implements Comparable<Task> {
    int taskId;
    int priority;
    Instant timestamp;

    public Task(int taskId, int priority) {
        this.taskId = taskId;
        this.priority = priority;
        this.timestamp = Instant.now(); // מקבל זמן מדויק בננו-שניות
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority); // Max-Heap לפי עדיפות
        }
        return this.timestamp.compareTo(other.timestamp);
    }
}