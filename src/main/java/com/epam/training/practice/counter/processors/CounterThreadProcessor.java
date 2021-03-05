package com.epam.training.practice.counter.processors;

import com.epam.training.practice.counter.entities.Counter;
import com.epam.training.practice.counter.entities.CounterRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CounterThreadProcessor {

    private static final int THREAD_COUNT = 10;

    public void process() {

        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();

        IntStream.range(0, THREAD_COUNT).forEach(increment -> {
            Thread thread = new Thread(new CounterRunnable(counter));
            thread.start();
            threads.add(thread);
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage() + e);
            }
        });

        System.out.println(counter.getValue());
    }

}
