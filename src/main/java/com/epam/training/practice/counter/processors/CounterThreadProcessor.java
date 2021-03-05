package com.epam.training.practice.counter.processors;

import com.epam.training.practice.counter.entities.Counter;
import com.epam.training.practice.counter.entities.CounterRunnable;

import java.util.ArrayList;
import java.util.List;

public class CounterThreadProcessor {

    private static final int THREAD_COUNT = 10;

    public void process() throws InterruptedException {

        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new CounterRunnable(counter));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage() + e);
                throw new InterruptedException(e.getMessage());
            }
        }

        System.out.println(counter.getValue());
    }

}
