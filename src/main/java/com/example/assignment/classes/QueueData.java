package com.example.assignment.classes;

import java.util.LinkedList;
import java.util.Queue;

public class QueueData {


    public Queue<String> q;
    int capacity;

    public QueueData(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    public synchronized void produce(String msg) throws InterruptedException {
        if (q.size() == capacity) {
            System.out.println(" Capacity full... Producer waiting.");
            wait();
        }
        System.out.println("Produced Msg : " + msg);
        q.add(msg);
        notifyAll();
    }


    public synchronized void consume() throws InterruptedException {
        String name=Thread.currentThread().getName();
        if (q.isEmpty()) {
            System.out.println(name+" waiting for new message...");
            wait();
        }
        String msg = q.poll();
        System.out.println("Consumed Msg : " + msg);
        notifyAll();
    }

}
