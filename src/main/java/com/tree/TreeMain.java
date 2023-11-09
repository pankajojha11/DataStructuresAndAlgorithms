package com.tree;

public class TreeMain {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        TreeTraversal traversal = new TreeTraversal();
        traversal.inOrder(root);
        System.out.println("inOrder Recursive");
        System.out.println("--------------------------------");
        System.out.println(traversal.inOrderIterative(root) + " inOrder Iterative");
        System.out.println("--------------------------------");
        traversal.preOrder(root);
        System.out.println("preOrder Recursive");
        System.out.println("--------------------------------");
        System.out.println(traversal.preOrderIterative(root) + " preOrder Iterative");
        System.out.println("--------------------------------");
        traversal.postOrder(root);
        System.out.println("postOrder Recursive");
        System.out.println("--------------------------------");
        System.out.println(traversal.postOrderIterative(root) + " postOrder Iterative");
        System.out.println("--------------------------------");
        System.out.println(traversal.levelOrderIterative(root) + " levelOrder Iterative");
        System.out.println("--------------------------------");
        System.out.println(traversal.levelOrderIterativeListOfList(root) + " levelOrder Iterative list of list");
        System.out.println("--------------------------------");
        System.out.println(traversal.leftViewOfBinaryTree(root) + " left view of binary tree");
        System.out.println("--------------------------------");
        System.out.println(traversal.rightViewOfBinaryTree(root) + " right view of binary tree");
        System.out.println("--------------------------------");
        System.out.println(traversal.rightViewOfBinaryTreeAtEveryLevel(root) + " right view at every level");
        System.out.println("--------------------------------");
        System.out.println("Height of a binary tree : " + traversal.heightOfBinaryTree(root));
        System.out.println("--------------------------------");
        System.out.println(traversal.isValidBST(root) + " validate binary search tree");
        System.out.println("--------------------------------");
        System.out.println(traversal.kthSmallestInBST(root, 4) + " kth smallest in binary search tree");
        System.out.println("--------------------------------");
        System.out.println(traversal.findAllLeafNodes(root) + " find all leaf nodes using level order");
        System.out.println("--------------------------------");
        System.out.println(traversal.findAllLeafNodesInOrder(root) + " find all leaf nodes using in order");
        System.out.println("--------------------------------");
        System.out.println(traversal.levelOrderIterativeListOfList(root) + " level order Iterative list of list");
        System.out.println("--------------------------------");
        System.out.println(traversal.reverseLevelOrderIterativeListOfList(root) + " reverse levelOrder Iterative list of list");
        System.out.println("--------------------------------");
        System.out.println(traversal.zigzagTraversal(root) + " zigzag order with reverse method");
        System.out.println("--------------------------------");
        System.out.println(traversal.zigzagTraversalWithoutReverse(root) + " zigzag order without reverse method");
        System.out.println("--------------------------------");
        System.out.println(traversal.reverseOddLevel(root) + " reverse odd level");
        System.out.println("--------------------------------");
        System.out.println(traversal.averageOfLevel(root) + " average of level");
        System.out.println("--------------------------------");
        System.out.println(traversal.largestValueOfLevel(root) + " largest value of level");
        System.out.println("--------------------------------");
        System.out.println(traversal.levelOrderSuccessor(root, 0) + " level order successor");
        System.out.println("--------------------------------");
        traversal.connectSuccessor(root);
        System.out.println("--------------------------------");
        traversal.connectSuccessorLevel(root);
        System.out.println("--------------------------------");
        System.out.println(traversal.shortestPathFromRootToTarget(root, 5));
        System.out.println("--------------------------------");
        System.out.println(traversal.shortestPathFromRootToTargetNotToVisitTwice(root, 5));
        System.out.println("--------------------------------");
        System.out.println("Thanks");
        System.out.println("DSA");
    }
}
