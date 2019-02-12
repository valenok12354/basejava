package com.company.webapp;

public class MainConcurrency {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "," + getState());
            }
        };
        thread0.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().getState());
            }
            private void inc() {
                synchronized (this){
                    counter++;
                }
            }

        }).start();
        System.out.println(thread0.getState());
        for (int i = 0; i < 10_000; i++) {
           Thread thread= new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                }
            });
           thread.start();
           thread.join();
        }
        System.out.println(counter);

    }

    private synchronized void inc() {
        counter++;
    }
}
