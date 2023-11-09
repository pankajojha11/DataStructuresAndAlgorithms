package com.queue;

public class MyQueueUsingLinkedList {

    Node front, rear;


    void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() throws Exception {
        if (front == null)
            throw new Exception("Queue is empty");
        int res = front.data;
        front = front.next;
        return res;
    }
}
