package com.example;

// Shared resource
class Counter {
    private int count = 0;

    // Synchronized method to ensure thread safety
    // Only one thread can execute this method at a time on the same instance
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Runnable task to increment the counter
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        // Create two threads sharing the same Counter instance
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        try {
            // Wait for both threads to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Without synchronization, the count would likely be less than 2000 due to race conditions
        System.out.println("Final Count (Expected 2000): " + counter.getCount());
    }
}
