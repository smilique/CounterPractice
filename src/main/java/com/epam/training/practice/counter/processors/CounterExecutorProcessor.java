package com.epam.training.practice.counter.processors;

import com.epam.training.practice.counter.entities.Counter;
import com.epam.training.practice.counter.entities.CounterCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CounterExecutorProcessor {

    private static final int THREAD_COUNT = 10;

    public void process() {

        Counter counter = new Counter();
        List<Future<Number>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        IntStream.range(0,THREAD_COUNT).forEach(number -> {
            futures.add(
                    executorService.submit(new CounterCallable(counter)));
        });

        executorService.shutdown();

        futures.forEach(future -> {
            try {
                int newValue = (int) future.get();
                counter.setValue(newValue);
            } catch (Exception e) {
                System.err.println(e.getMessage() + e);
            }
        });

        System.out.println(counter.getValue());
    }

}
