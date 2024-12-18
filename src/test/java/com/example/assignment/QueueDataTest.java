package com.example.assignment;

import com.example.assignment.classes.QueueData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueDataTest {


    @Test
    void testProduce() throws InterruptedException {
        QueueData queueData = new QueueData(3);
        queueData.produce("Test Message");
        assertEquals(1, queueData.q.size());
    }

    @Test
    void testConsume() throws InterruptedException {
        QueueData queueData = new QueueData(3);

        queueData.produce("Test Message1");
        queueData.produce("Test Message2");
        assertEquals(2, queueData.q.size());

        queueData.consume();
        assertEquals(1, queueData.q.size());

    }

}
