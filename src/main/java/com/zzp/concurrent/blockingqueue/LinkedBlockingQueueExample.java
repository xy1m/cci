package com.zzp.concurrent.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {
    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
