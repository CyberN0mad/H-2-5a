package com.company;

public class Uploader extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("Added 1 file 500 mb/s");
            System.out.print("Uploading file, please wait");
            for (int i = 0; i < 5; i++) {
                System.out.print(" .");
                sleep(1000);
            }
            System.out.println("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
