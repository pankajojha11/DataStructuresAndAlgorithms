package com.linkedlist;

public class LinkedListTraversal {

    public static void traverse(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    // insert at a particular position
    public static void insert(int data, Node head, int pos) {
        Node toAdd = new Node(data);
        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
            return;
        }
        Node cur = head;
        for (int i = 0; i < pos - 1; i++) {
            cur = cur.next;
        }
        toAdd.next = cur.next;
        cur.next = toAdd;
    }

    // delete at a particular position
    // all edge case not passing
    public static void delete(Node head, int pos) {
        if (pos == 0) {
            head = head.next;
            return;
        }
        Node cur = head;
        for (int i = 0; i < pos - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static Node deleteAtKthPosition(Node head, int k) {
        if (head == null)
            return null;
        if (k == 1) {
            head = head.next;
            return head;
        }
        int length = findLengthOfLinkedList(head);
        if (k > length)
            return null;
        Node cur = head;
        for (int i = 0; i < k - 2; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static Node deleteWithValue(Node head, int value) {
        if (head == null)
            return null;
        if (value == head.data) {
            head = head.next;
            return head;
        }
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            if (cur.data == value) {
                if (prev != null)
                    prev.next = prev.next.next;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static Node reverseLinkedList(Node head) {
        // iterative method
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static Node reverseLinkedListRecursive(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = reverseLinkedListRecursive(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null)
            return true;
        Node mid = middle(head);
        Node last = reverseLinkedList(mid.next);
        Node cur = head;
        while (last != null) {
            if (cur.data != last.data)
                return false;
            last = last.next;
            cur = cur.next;
        }
        return true;
    }

    public static Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return slow;
        }
        return null;
    }

    public static Node detectFirstNode(Node head) {
        Node meet = detectCycle(head);
        Node start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }
        return start;
    }

    public static String removeCycle(Node head) {
        Node meet = detectCycle(head);
        Node start = head;
        Node prev = meet;
        boolean flag = false;
        while (start != meet) {
            if (flag == true)
                prev = meet;
            start = start.next;
            meet = meet.next;
            flag = true;
        }
        prev.next = null;
        return "Removed Cycle";
    }

    public static int findLengthOfCycle(Node head) {
        Node meet = detectCycle(head);
        Node cur = meet.next;
        int count = 0;
        while (cur != meet) {
            count++;
            cur = cur.next;
        }
        return count + 1;
    }

    public static boolean findHappyNumber(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = findSum(slow);
            fast = findSum(findSum(fast));
        }
        while (fast != slow && fast != 1);
        return fast == 1;
    }

    private static int findSum(int num) {
        int sum = 0;
        int digit = 0;
        while (num > 0) {
            digit = num % 10;
            sum = sum + digit * digit;
            num = num / 10;
        }
        return sum;
    }


    public static Node createLinkedListFromArray(int[] arr) {
        if (arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }


    public static int findLengthOfLinkedList(Node head) {
        int length = 0;
        Node cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public static boolean searchElementInLinkedList(Node head, int element) {
        if (head == null)
            return false;
        Node cur = head;
        while (cur != null) {
            if (cur.data == element)
                return true;
            cur = cur.next;
        }
        return false;
    }

    public static Node deleteAtHead(Node head) {
        if (head == null)
            return null;
        head = head.next;
        return head;
    }

    public static Node deleteAtTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static Node deleteAtKth(Node head, int k) {
        if (head == null)
            return null;
        if (k == 1) {
            head = head.next;
            return head;
        }
        int count = 0;
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static Node deleteWithVa(Node head, int value) {
        if (head == null)
            return null;
        if (head.data == value) {
            head = head.next;
            return head;
        }
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            if (cur.data == value) {
                prev.next = prev.next.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static Node insertAtHead(Node head, int element) {
        if (head == null)
            return new Node(element);
        Node temp = new Node(element);
        temp.next = head;
        head = temp;
        return head;
    }

    public static Node insertAtTail(Node head, int element) {
        if (head == null)
            return new Node(element);
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(element);
        return head;
    }

    public static Node insertAtkth(Node head, int k, int element) {
        if (head == null)
            if (k == 1) {
                return new Node(element);
            } else
                return null;
        if (k == 1) {
            Node temp = new Node(element);
            temp.next = head;
            head = temp;
        }
        Node cur = head;
        Node prev = null;
        int count = 0;
        while (cur != null) {
            count++;
            if (count == k) {
                Node newNode = new Node(element);
                newNode.next = cur;
                prev.next = newNode;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;

    }

    public static Node reverseNodeKthGroupSize(Node head, int k) {
        Node cur = head;
        Node kthNode = null;
        Node nextNode = null;
        Node prevNode = null;
        while (cur != null) {
            kthNode = findKthNode(head, k);
            if (kthNode == null) {
                if (prevNode != null)
                    prevNode.next = cur;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(cur);
            if (cur == head)
                head = kthNode;
            else
                prevNode.next = kthNode;
            prevNode = cur;
            cur = nextNode;
        }
        return head;
    }

    private static Node findKthNode(Node head, int k) {
        Node cur = head;
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
            if (cur == null)
                break;
        }
        return cur;
    }

    public static Node rotateLinkedList(Node head, int k) {
        if (head == null || k == 0)
            return head;
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        if (k % length == 0)
            return head;
        k = k % length;
        tail.next = head;
        Node newLastNode = findKthNodeForRotate(head, length - k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

    public static Node findKthNodeForRotate(Node head, int k) {
        Node cur = head;
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
