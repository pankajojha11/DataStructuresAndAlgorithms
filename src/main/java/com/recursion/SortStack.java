package com.recursion;

import java.util.Stack;

public class SortStack {

    static void sort(Stack<Integer> stack) {
        // base condition
        if (stack.size() == 1)
            return;
        int temp = stack.peek();
        stack.pop();
        sort(stack);
        insert(stack, temp);
        return;
    }

    static void insert(Stack<Integer> stack, int temp) {
        if (stack.size() == 0 || stack.peek() == temp) {
            stack.push(temp);
            return;
        }
        int val = stack.peek();
        stack.pop();
        insert(stack, temp);
        stack.add(val);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(6);
        sort(stack);
    }
}
