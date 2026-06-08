package com.learn.algorithms.algo;
import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


public class RateLimit {
    private final ConcurrentHashMap<String, Queue<Instant>> userRequestsMap;
    private final int maxSizeOfRequests;
    private final long lifespanInSeconds;


    public RateLimit() {
        this.userRequestsMap = new ConcurrentHashMap<>();
        this.maxSizeOfRequests = 5;
        this.lifespanInSeconds = 5;
    }


    public boolean addRequest(String userId) {
        Instant now = Instant.now();
        Queue<Instant> requests = userRequestsMap.computeIfAbsent(userId, k -> new ConcurrentLinkedQueue<>());

        synchronized (requests) {
            removeOutdated(requests, now);
            if (requests.size() >= maxSizeOfRequests) {
                System.out.println("User id not allowed");
                return false;
            }
            requests.add(now);
            System.out.println("User is allowed");
            return true;
        }
    }


    private void removeOutdated(Queue<Instant> requests, Instant now) {
        while (!requests.isEmpty()) {
            Instant earliestRequest = requests.peek();
            if (now.getEpochSecond() - earliestRequest.getEpochSecond() > lifespanInSeconds) {
                requests.poll();
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        RateLimit rateLimit = new RateLimit();
        int interval = 1000;
        for (int i = 1; i <= 20; i++) {
            rateLimit.addRequest("A1");
            Thread.sleep(interval);
        }

    }

  }




