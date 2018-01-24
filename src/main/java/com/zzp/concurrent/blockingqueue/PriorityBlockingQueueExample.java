package com.zzp.concurrent.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<String> queue=new PriorityBlockingQueue<>();
        queue.add("Value");
        queue.add("Xde");
        queue.add("Cde");
        queue.add("123");
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
