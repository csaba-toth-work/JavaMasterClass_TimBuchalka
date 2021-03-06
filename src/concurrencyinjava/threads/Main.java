package concurrencyinjava.threads;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + " Hello from anonymous class implementation of run");
                try {
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated, so Im running again");
                } catch (InterruptedException e) {
                    System.out.println("I couldnt wait after all. I was interrupted");
                }
            }
        });

        myRunnableThread.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");


    }
}
