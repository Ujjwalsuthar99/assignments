Message Producer-Consumer Application

This Java application demonstrates a simple Producer-Consumer scenario using a queue. The producer generates messages and the consumer processes them, while keeping track of success and error counts.


Producer: Generates 20 messages and adds them to a queue.
Consumer: Processes messages with a random success rate and tracks success/failure counts.
Queue: Uses a queue with a capacity of 5.
Synchronization: Uses synchronized methods for thread-safe access to the queue and employs wait() and notifyAll() to manage thread states when the producer is full or the consumer is waiting for messages.
Logging: Logs the produced and consumed messages along with final statistics.


You can run this application with spring boot and with the particular Main class

for Spring Boot cmd -->
mvn spring-boot:run

for Normal JAVA code
compile cmd -->
javac -d bin src/com/example/assignment/classes/*.java

run cmd -->
java -cp bin com.example.assignment.classes.Main

for Test cases -->
mvn -Dtest=QueueDataTest#testConsume test