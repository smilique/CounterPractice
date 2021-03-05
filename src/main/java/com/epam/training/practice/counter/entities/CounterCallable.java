package com.epam.training.practice.counter.entities;

import java.util.concurrent.Callable;

public class CounterCallable implements Callable<Number> {

    private static final int INCREMENTS = 100;
    private final Counter counter;


    @Override
    public Number call() {
        for (int i = 0; i < INCREMENTS; i++) {
            try {
                counter.increment();
                Thread.sleep(10);
            } catch (Exception e) {
                System.err.println(e.getMessage() + " " + e);
            }
        }
        return counter.getValue();
    }

    public CounterCallable(Counter counter) {
        this.counter = counter;
    }

    public Counter getCounter () {
        return counter;
    }


}
