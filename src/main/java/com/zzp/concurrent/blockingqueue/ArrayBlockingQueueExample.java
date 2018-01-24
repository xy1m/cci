package com.zzp.concurrent.blockingqueue;

import java.util.concurrent.*;

public class ArrayBlockingQueueExample {
    public static void main(String... args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

