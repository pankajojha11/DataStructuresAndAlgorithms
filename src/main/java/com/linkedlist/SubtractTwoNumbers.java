package com.linkedlist;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class SubtractTwoNumbers {

    private static void traverse(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
    }


    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    private static ListNode subtractLinkedList(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // reverse the both linked-list
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode head = new ListNode(-1);
        ListNode itr = head;
        ListNode c1 = l1, c2 = l2;

        int borrow = 0;
        while (c1 != null) {
            int diff = borrow + c1.data - ((c2 != null) ? c2.data : 0);
            if (diff < 0) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }

            itr.next = new ListNode(diff);
            itr = itr.next;
            c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }
        return reverse(head.next);
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(0);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(0);
        l2.next.next = null;

        ListNode result = subtractLinkedList(l1, l2);
        traverse(result);


    }
}
