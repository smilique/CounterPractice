package com.epam.training.practice.counter.entities;

public class CounterRunnable implements Runnable {

    private static final int INCREMENTS = 100;
    private final Counter counter;

    @Override
    public void run() {
        for (int i = 0; i < INCREMENTS; i++) {
            try {
                counter.increment();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage() + " " + e);
            }
        }

    }

    public CounterRunnable (Counter counter) {
        this.counter = counter;
    }

    public Counter getCounter () {
        return counter;
    }
}
