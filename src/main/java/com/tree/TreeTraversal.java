package com.tree;

import java.util.*;

public class TreeTraversal {

    void inOrder(TreeNode root) {
        // base condition
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null)
            return inOrder;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            inOrder.add(cur.data);
            cur = cur.right;
        }
        return inOrder;
    }

    void preOrder(TreeNode root) {
        // base condition
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null)
            return preOrder;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            preOrder.add(root.data);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
        return preOrder;
    }

    void postOrder(TreeNode root) {
        // base condition
        if (root == null)
            return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
    }

    List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null)
            return postOrder;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode temp = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (cur.right == null || cur.right == temp) {
                    postOrder.add(cur.data);
                    stack.pop();
                    temp = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
//            temp = stack.peek().right;
//            if (temp == null) {
//                temp = stack.pop();
//                postOrder.add(temp.data);
//                while (!stack.isEmpty() && temp == stack.peek().right) {
//                    temp = stack.pop();
//                    postOrder.add(temp.data);
//                }
//            } else
//                cur = temp;
        }
        return postOrder;
    }

    List<Integer> levelOrderIterative(TreeNode root) {
        List<Integer> levelOrder = new ArrayList<>();
        if (root == null)
            return levelOrder;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            levelOrder.add(cur.data);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return levelOrder;
    }

    List<List<Integer>> levelOrderIterativeListOfList(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null)
            return levelOrder;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                currentLevel.add(cur.data);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            levelOrder.add(currentLevel);
        }
        return levelOrder;
    }

    List<List<Integer>> reverseLevelOrderIterativeListOfList(TreeNode root) {
        List<List<Integer>> reverseLevelOrder = new ArrayList<>();
        if (root == null)
            return reverseLevelOrder;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                currentLevel.add(cur.data);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            reverseLevelOrder.add(0, currentLevel);
        }
        return reverseLevelOrder;
    }

    List<List<Integer>> zigzagTraversal(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        if (root == null)
            return zigzagList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                currentLevel.add(cur.data);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            depth++;
            if (depth % 2 == 0) {
                Collections.reverse(currentLevel);
            }
            zigzagList.add(currentLevel);
        }
        return zigzagList;
    }

    List<List<Integer>> zigzagTraversalWithoutReverse(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        if (root == null)
            return zigzagList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (leftToRight)
                    currentLevel.add(cur.data);
                else
                    currentLevel.add(0, cur.data);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            zigzagList.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return zigzagList;
    }

    TreeNode reverseOddLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
                if (leftToRight) {
                    TreeNode temp = cur.left;
                    cur.left = cur.right;
                    cur.right = temp;
                }
            }
            leftToRight = !leftToRight;
        }
        return root;
    }

    List<Float> averageOfLevel(TreeNode root) {
        List<Float> averageList = new ArrayList<>();
        if (root == null)
            return averageList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        float sum = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                sum += cur.data;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            averageList.add(sum / levelSize);
            sum = 0;
        }
        return averageList;
    }

    List<Integer> largestValueOfLevel(TreeNode root) {
        List<Integer> largestValueList = new ArrayList<>();
        if (root == null)
            return largestValueList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxLevelValue = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                maxLevelValue = Math.max(maxLevelValue, cur.data);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            largestValueList.add(maxLevelValue);
        }
        return largestValueList;
    }

    int levelOrderSuccessor(TreeNode root, int givenNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            if (cur.data == givenNode)
                return queue.poll().data;
        }
        return -1;
    }

    void connectSuccessor(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.data + "--->");
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            System.out.println("null");
        }

    }

    void connectSuccessorLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.data + "--->");
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }
        System.out.println("null");
    }

    List<Integer> rightViewOfBinaryTreeAtEveryLevel(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        if (root == null)
            return rightViewList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = root;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                cur = queue.poll();
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            rightViewList.add(cur.data);
        }
        return rightViewList;
    }

    int heightOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            height++; // Increment height after processing a level
        }
        return height;
    }

    List<Integer> leftViewOfBinaryTree(TreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        if (root == null)
            return leftView;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean firstNodeInLevel = true;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (firstNodeInLevel) {
                    leftView.add(cur.data);
                    firstNodeInLevel = false;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return leftView;
    }

    List<Integer> rightViewOfBinaryTree(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null)
            return rightView;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (i == levelSize - 1) {
                    rightView.add(cur.data);
                }
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }
        return rightView;
    }

    boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.data >= cur.data)
                return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    int kthSmallestInBST(TreeNode root, int k) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0)
                return cur.data;
            cur = cur.right;
        }
        return -1;
    }

    List<Integer> findAllLeafNodes(TreeNode root) {
        List<Integer> levelOrder = new ArrayList<>();
        if (root == null)
            return levelOrder;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null && cur.right == null)
                levelOrder.add(cur.data);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        return levelOrder;
    }

    List<Integer> findAllLeafNodesInOrder(TreeNode root) {
        List<Integer> leafNode = new ArrayList<>();
        if (root == null)
            return leafNode;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null)
                leafNode.add(cur.data);
            cur = cur.right;
        }
        return leafNode;
    }

    int shortestPathFromRootToTarget(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            step = step + 1;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.data == target)
                    return step;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }
        return -1;
    }

    int shortestPathFromRootToTargetNotToVisitTwice(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<TreeNode> visited = new HashSet<>(); // stores all the nodes that we have visited
        visited.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            step = step + 1;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.data == target)
                    return step;
                if (cur.left != null && !visited.contains(cur.left)) {
                    queue.add(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    queue.add(cur.right);
                    visited.add(cur.right);
                }
            }
        }
        return -1;
    }

}


