package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private int user;

    private CountDownLatch cdl;
    private Semaphore semaphore;

    public Downloaders(int donwloaders, CountDownLatch cdl, Semaphore semaphore) {
        this.user = donwloaders;
        this.cdl = cdl;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        super.run();
        try {
            semaphore.acquire();
            System.out.println("User " + user + " start downloading file 100mb/s");
            sleep(1000);
            System.out.println("User " + user + " finished downloading. ");
            semaphore.release();
            cdl.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
