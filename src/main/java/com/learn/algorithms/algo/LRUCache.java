package com.learn.algorithms.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache — תכנון מנגנון פינוי זיכרון מטמון (Least Recently Used).
 * <p>
 * Time: O(1) per {@link #get} and {@link #put}.
 * Space: O(capacity).
 */
public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }
        if (map.size() == capacity) {
            evictLeastRecentlyUsed();
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);
    }

    private void moveToFront(Node node) {
        detach(node);
        insertAfterHead(node);
    }

    private void insertAfterHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void detach(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void evictLeastRecentlyUsed() {
        Node lru = tail.prev;
        detach(lru);
        map.remove(lru.key);
    }

    private static final class Node {
        final int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
