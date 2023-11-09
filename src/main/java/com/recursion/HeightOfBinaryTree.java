package com.recursion;

public class HeightOfBinaryTree {
    private static int height(Node root) {

        // base condition
        if (root == null)
            return 0;

        // hypothesis
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // induction
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Height(Depth) of tree is: " + height(root));
    }

    static class Node {
        int node;
        Node left;
        Node right;

        public Node(int node) {
            this.node = node;
            this.left = null;
            this.right = null;
        }
    }

}
