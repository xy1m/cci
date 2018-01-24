package com.zzp.concurrent.blockingqueue;

import java.time.Instant;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class DelayedQueueExample {
    public static void main(String[] args) {
        DelayQueue queue = new DelayQueue();
        try {
            DelayedItem d1 = new DelayedItem("a", 1000);
            DelayedItem d2 = new DelayedItem("b", 2000);
            DelayedItem d3 = new DelayedItem("c", 5000);
            queue.add(d1);
            queue.add(d2);
            queue.add(d3);
            while (true) {
                System.out.println(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DelayedItem<T> implements Delayed {
        private final T item;
        private final long now;
        private final long delay;
        private final long expire;
        private AtomicLong number = new AtomicLong();

        public DelayedItem(T item, long delay) {
            this.item = item;
            this.delay = delay;
            this.now = Instant.now().toEpochMilli();
            this.expire = this.now + this.delay;
        }

        public String toString() {
            return String.format("DelayedItem=%s,%s,%s,%s", item, now, delay, expire);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long duration = expire - Instant.now().toEpochMilli();
            return unit.convert(duration, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == this) return 0;
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}
