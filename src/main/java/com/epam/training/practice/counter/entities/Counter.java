package com.epam.training.practice.counter.entities;

public class Counter {

    private int value = 0;

    public synchronized void increment() {
        value++;
    }

    public synchronized int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
