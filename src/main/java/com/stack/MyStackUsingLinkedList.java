package com.stack;

import java.util.Stack;

public class MyStackUsingLinkedList {
    Node head;
    int size;

    public MyStackUsingLinkedList() {
        head = null;
        size = 0;
    }

    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() throws Exception {
        if (head == null)
            throw new Exception("Underflow condition stack is empty");
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    int peek() throws Exception {
        if (head == null)
            throw new Exception("Underflow condition stack is empty");
        return head.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }

}
