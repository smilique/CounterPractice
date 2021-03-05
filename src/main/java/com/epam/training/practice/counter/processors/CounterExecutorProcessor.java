package com.epam.training.practice.counter.processors;

import com.epam.training.practice.counter.entities.Counter;
import com.epam.training.practice.counter.entities.CounterCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CounterExecutorProcessor {

    private static final int THREAD_COUNT = 10;

    public void process() throws Exception {

        Counter counter = new Counter();
        List<Future<Number>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new CounterCallable(counter)));
        }
        executorService.shutdown();

        for (Future<Number> fut : futures) {
            try {
                int newValue = (int)fut.get();
                counter.setValue(newValue);

            } catch (Exception e) {
                System.err.println(e.getMessage() + e);
                throw new Exception(e.getMessage(),e);
            }
        }

        System.out.println(counter.getValue());
    }

}
