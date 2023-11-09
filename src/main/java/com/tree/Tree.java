package com.tree;

import java.util.*;

public class Tree {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    // retrun root node
    static Node createTree() {
        Node root = null;
        System.out.println("Enter data : ");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        root = new Node(data);
        System.out.println("Enter left for " + data);
        root.left = createTree();
        System.out.println("Enter right for " + data);
        root.right = createTree();
        return root;
    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // size means how many nodes are there
    int size(Node root) {
        if (root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    int maximum(Node root) {
        if (root == null)
            return 0;
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
    }

    void printCurrentLevel(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.data);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }



    void printLeftView(Node root) {
        List<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);
        for (Node cur : list) {
            System.out.println(cur.data + "");
        }
    }

    void printLeftViewUtil(Node root, List<Node> list, int level) {
        if (root == null)
            return;
        if (list.get(level) == null) {
            list.add(root);
        }
        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

