package com.epam.training.practice.counter;


import com.epam.training.practice.counter.processors.CounterExecutorProcessor;
import org.junit.Test;

public class CounterExecutorProcessorTest {

    @Test
    public void testCounterExecutorProcessor() throws Exception {

        CounterExecutorProcessor processor = new CounterExecutorProcessor();
        processor.process();

    }
}