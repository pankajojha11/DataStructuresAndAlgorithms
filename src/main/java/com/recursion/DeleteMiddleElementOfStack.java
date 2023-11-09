package com.recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {
    private static Stack<Character> deleteMiddleElementOfStack(Stack<Character> st, int size) {
        if (size == 0)
            return st;
        int k = size / 2 + 1;
        solve(st, k);
        return st;

    }

    private static void solve(Stack<Character> st, int k) {
        if (k == 1) {
            st.pop();
            return;
        }
        char temp = st.peek();
        st.pop();
        solve(st, k - 1);
        st.push(temp);
        return;
    }

    public static void main(String[] args) {
        Stack<Character> st = new Stack<Character>();
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');
        st.push('6');
        st.push('7');
        System.out.println(deleteMiddleElementOfStack(st, st.size()));
    }
}
