package concurrencyinjava.starvation;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 10");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 10");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 10");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 10");

        t1.setPriority(10);
        t1.setPriority(8);
        t1.setPriority(6);
        t1.setPriority(4);
        t1.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}