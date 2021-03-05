package com.epam.training.practice.counter;


import com.epam.training.practice.counter.processors.CounterThreadProcessor;
import org.junit.Test;

public class CounterThreadProcessorTest {

    @Test
    public void testCounterThreadProcessorShouldCountDesired() throws InterruptedException {

        CounterThreadProcessor processor = new CounterThreadProcessor();
        processor.process();

    }
}