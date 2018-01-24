package com.zzp.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                queue.put(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
