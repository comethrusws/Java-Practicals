package com.example;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread 1 (" + Thread.currentThread().getId() + ") is running (Extends Thread)");
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 1: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// with runnable interfaces
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread 2 (" + Thread.currentThread().getId() + ") is running (Implements Runnable)");
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 2: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        System.out.println("Main thread starting...");

        MyThread t1 = new MyThread();

        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();

        System.out.println("Main thread ended (child threads may continue).");
    }
}
