package com.example.assignment.classes;

import java.util.Random;

public class Consumer implements Runnable {
    QueueData queueData;
    int successCount;
    int failureCount;

    public Consumer(QueueData data, int success, int failure) {
        this.queueData = data;
        this.failureCount = failure;
        this.successCount = success;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(2000);
                queueData.consume();
                if (random()) {
                    successCount++;
                } else {
                    failureCount++;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Error --> Consumer : " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public boolean random() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
