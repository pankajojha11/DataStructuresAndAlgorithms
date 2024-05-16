package com.linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {
//        Node n1 = new Node(10);
//        Node n2 = new Node(20);
//        Node n3 = new Node(30);
//
//        Node head1 = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = null;

//        Node n4 = new Node(40);
//        Node n5 = new Node(50);
//        Node n6 = new Node(60);
//
//        Node head2 = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = null;

//        Node resultMergeList = mergeTwoList(head1, head2);
//        traverse(resultMergeList);


//        traverse(head1);
//        delete(n2);
//        traverse(head);
//        insert(40, head, 1);
//        traverse(head);
//        delete(head, 3);
//        traverse(head);
//        reverseLinkedList(head);
//        System.out.println(isPalindrome(head));

//        Node n1 = new Node(2);
//        Node n2 = new Node(1);
//        Node n3 = new Node(2);
//
//        Node head = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = null;
//        Node node = deleteDuplicatesInAnUnSortedList(head);
//        traverse(node);

//        Node n1 = new Node(0);
//        Node n2 = new Node(2);
//        Node n3 = new Node(1);
//
//        Node head = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = null;
//
//        sortUsingDutchNationalFlagAlgorithm(head);
//        traverse(head);


        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

//        Node n1 = new Node(1);
//        Node n2 = new Node(1);
//        Node n3 = new Node(2);
//        Node n4 = new Node(1);


        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        Node headForCycleDetection = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        LinkedListTraversal traversal = new LinkedListTraversal();
        traversal.traverse(head);
        System.out.println("--------------------------------");
        traversal.insert(50, head, 2);
        traversal.traverse(head);
        System.out.println("--------------------------------");
        traversal.delete(head, 2);
        traversal.traverse(head);
        System.out.println("--------------------------------");
        Node createLinkedListFromArrayHead = traversal.createLinkedListFromArray(new int[]{1, 5, 3, 4});
        System.out.println("createLinkedListFromArray");
        traversal.traverse(createLinkedListFromArrayHead);
        System.out.println("--------------------------------");
        System.out.println("LengthOfLinkedList");
        System.out.println(traversal.findLengthOfLinkedList(createLinkedListFromArrayHead));
        System.out.println("--------------------------------");
        System.out.println("searchElementInLinkedList");
        System.out.println(traversal.searchElementInLinkedList(createLinkedListFromArrayHead, 1));
        System.out.println("--------------------------------");
        System.out.println("deleteTail");
        traversal.traverse(traversal.deleteTail(createLinkedListFromArrayHead));
        System.out.println("--------------------------------");
        System.out.println("Original LinkedList");
        traversal.traverse(createLinkedListFromArrayHead);
        System.out.println("deleteAtKthPosition");
        traversal.traverse(traversal.deleteAtKthPosition(createLinkedListFromArrayHead, 2));
        System.out.println("--------------------------------");
        System.out.println("deleteWithValue");
        traversal.traverse(traversal.deleteWithValue(createLinkedListFromArrayHead, 1));
        System.out.println("--------------------------------");
        Node prev = traversal.reverseLinkedList(head);
        traversal.traverse(prev);
        System.out.println("--------------------------------");
        head = traversal.reverseLinkedListRecursive(prev);
        traversal.traverse(head);
        System.out.println("--------------------------------");
        System.out.println(traversal.isPalindrome(head));
        System.out.println("--------------------------------");
        System.out.println(traversal.detectCycle(headForCycleDetection) + "--------------------------------");
        System.out.println("--------------------------------");
        System.out.println(traversal.detectFirstNode(headForCycleDetection) + "--------------------------------");
        System.out.println("--------------------------------");
        System.out.println(traversal.findLengthOfCycle(headForCycleDetection));
        System.out.println("--------------------------------");
        System.out.println(traversal.removeCycle(headForCycleDetection));
        traversal.traverse(head);
        System.out.println("--------------------------------");
        System.out.println(traversal.findHappyNumber(7));
        System.out.println("--------------------------------");
        System.out.println(traversal.rotateLinkedList(head, 5));
        traversal.traverse(head);


    }
}
