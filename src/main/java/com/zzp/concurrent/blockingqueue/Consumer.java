package com.zzp.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Thread=" + Thread.currentThread().getId() + ":" + queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
