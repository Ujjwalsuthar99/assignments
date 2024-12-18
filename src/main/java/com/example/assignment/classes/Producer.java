package com.example.assignment.classes;

public class Producer implements Runnable {
    QueueData queueData;
    public Producer(QueueData data) {
        this.queueData = data;
    }

    final String[] messages = {"1", "2", "3", "4", "5"};

    @Override
    public void run() {
        int i = 0;
        try {
            for (int j = 0; j < 20; j++) {
                Thread.sleep(1000);
                queueData.produce(messages[i]);
                i = (i+1)%messages.length;
                System.out.println("queueData " + queueData.q);
            }
        } catch (InterruptedException e) {
            System.out.println("Error --> Producer : " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
