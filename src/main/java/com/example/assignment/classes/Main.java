package com.example.assignment.classes;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Logger logger = Logger.getLogger(Main.class.getName());
        int success = 0;
        int failure = 0;
        QueueData data = new QueueData(5);
        Thread producer = new Thread(new Producer(data), "Producer");
        Thread consumer = new Thread(new Consumer(data, success, failure), "Consumer");
        producer.start();
        consumer.start();


        // waiting for finishing their jobs
        producer.join();
        consumer.join();


        logger.info("Total successful messages: " + success);
        logger.info("Total errors: " + failure);

    }
}