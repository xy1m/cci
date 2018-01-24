package com.zzp.concurrent.blockingqueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousBlockingQueueExample {
    public static void main(String[] args){
        SynchronousQueue queue=new SynchronousQueue();
        new Thread(()->{
            try {
                queue.put(1);
                Thread.sleep(1000);
                queue.put(2);
                Thread.sleep(1000);
                queue.put(3);
                Thread.sleep(1000);
                queue.put(4);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(()->{
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
