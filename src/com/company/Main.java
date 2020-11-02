package com.company;
//a)  Написать многопоточное приложение, которое бы симулировало загрузку файлов на сервер.
//        И их скачивание. Используя классы Semaphore и CountDownLatch.
//        Либо можно использовать методы wait(), notify(), notifyAll().
//        b)  Uploader загружает 1 файл 500 мб на сервер. Скорость загрузки 20 мб в секунду.
//        Нужно в консоли отобразить процесс загрузки симулируя через sleep().
//        c)  После того как весь файл загружен на сервер Downloaders начинают его скачивать
//        со скоростью 100 мб в секунду. Должны скачать файл 10 человек, одновременно могут скачивать не более 3х человек.
//        d)  После того как файл был скачан 10 раз, он удаляется с сервера

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Uploader uploader = new Uploader();
        uploader.start();
        uploader.join();

        for (int i = 1; i <= countDownLatch.getCount(); i++) {
            new Downloaders(i, countDownLatch, semaphore).start();
        }
        countDownLatch.await();
        System.out.println("File is deleted");


    }
}
