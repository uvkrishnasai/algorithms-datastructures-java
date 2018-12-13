package concurrency;

import java.util.stream.IntStream;

/**
 * Instance methods
 * Static methods
 * Code blocks inside instance method
 * Code block inside static method
 */
public class SynchronizedBlocks {

    private static class CounterStatic {

        private static Integer count = 0;

        public static synchronized void increment() {
            count++;
        }

        public static void incrementUsingSyncBlock() {
            synchronized (SynchronizedBlocks.class) {
                count++;
            }
        }

    }

    private class Counter {

        private Integer counter = 0;

        public synchronized void increment() {
            counter++;
        }

        public void incrementUsingBlock() {
            synchronized (this.counter) {
                this.counter++;
            }
        }
    }

    private class CounterThread extends Thread {

        private Counter counter = null;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            IntStream.range(0, 10).forEach(i -> {
                counter.increment();
                counter.incrementUsingBlock();

                CounterStatic.increment();
                CounterStatic.incrementUsingSyncBlock();
            });
        }

    }

    public static void main(String[] args) {

        SynchronizedBlocks thisObj = new SynchronizedBlocks();
        Counter counter = thisObj.new Counter();
        Thread threadOne = thisObj.new CounterThread(counter);
        Thread threadTwo = thisObj.new CounterThread(counter);
        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(counter.counter);
        System.out.println(CounterStatic.count);
    }

}
