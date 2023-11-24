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
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            float sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                sum += cur.data;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            averageList.add(sum / levelSize);
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

    int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int result = lh > rh ? lh : rh;
        return result + 1;
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

    int nthNode(TreeNode root, int n) {
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
            if (--n == 0)
                return cur.data;
            cur = cur.right;
        }
        return -1;
    }

    int inOrderSuccessorOfBST(TreeNode root, int p) {
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
            if (p < cur.data)
                return cur.data;
            cur = cur.right;
        }
        return -1;
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
        if (root == null) {
            return 0;
        }
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

    // total numbers of nodes
    int size(TreeNode root) {
        // base conditon
        if (root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    int sizeIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            size++;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return size;
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

    List<Integer> distanceK(TreeNode root, int k, TreeNode target) {
        if (k == 0)
            return List.of(target.data);
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target); // first add the target node to queue
        visited.put(target, true);
        int curLevel = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null && visited.get(cur.left) == null) {
                    queue.add(cur.left);
                    visited.put(cur.left, true);
                }
                if (cur.right != null && visited.get(cur.right) == null) {
                    queue.add(cur.right);
                    visited.put(cur.right, true);
                }
                if (parentTrack.get(cur) != null && visited.get(parentTrack.get(cur)) == null) {
                    queue.add(parentTrack.get(cur));
                    visited.put(parentTrack.get(cur), true);
                }
            }
            curLevel++;
            if (curLevel == k)
                break;
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }
        return result;
    }

    void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                parentTrack.put(cur.left, cur);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                parentTrack.put(cur.right, cur);
                queue.add(cur.right);
            }
        }
    }

    int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0)
            return -1;
        Set<String> visited = new HashSet<>();
        Set<String> deadLocks = new HashSet<>(Arrays.asList(deadends));
        if (deadLocks.contains("0000"))
            return -1;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String cur = queue.poll();
                if (cur.equals(target))
                    return steps;
                for (int j = 0; j < cur.length(); j++) {
                    int digit = cur.charAt(j) - '0';
                    // forward direction
                    int forward = (digit + 1) % 10;
                    String newState = cur.substring(0, j) + forward + cur.substring(j + 1);

                }
            }
        }
        return 0;
    }

    List<List<Integer>> nAryLevelOrderTraversalListOfList(TreeNodeGenericNary root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null)
            return levelOrder;
        Queue<TreeNodeGenericNary> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> listToBeAdded = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNodeGenericNary cur = queue.poll();
                listToBeAdded.add(cur.data);
                if (!cur.children.isEmpty()) {
                    for (TreeNodeGenericNary gen : cur.children) {
                        queue.add(gen);
                    }
                }
            }
            levelOrder.add(listToBeAdded);
        }
        return levelOrder;
    }

    boolean hasPathSum(TreeNode root, int sum) {
        // base case
        if (root == null)
            return false;
        if (root.data == sum && root.left != null && root.right != null)
            return true;
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    boolean hasPathSumUsingStacks(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> eachtreeNodeSumStack = new Stack<>();
        stack.push(root);
        eachtreeNodeSumStack.push(root.data);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int curSum = eachtreeNodeSumStack.pop();
            if (cur.left == null && cur.right == null && curSum == sum)
                return true;
            if (cur.right != null) {
                stack.push(cur.right);
                eachtreeNodeSumStack.push(cur.right.data + curSum);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                eachtreeNodeSumStack.push(cur.left.data + curSum);
            }
        }
        return false;
    }

    boolean hasPathSumUsingQueue(TreeNode root, int sum) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> eachtreeNodeSumQueue = new LinkedList<>();
        queue.add(root);
        eachtreeNodeSumQueue.add(root.data);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curSum = eachtreeNodeSumQueue.poll();
            if (cur.left == null && cur.right == null && curSum == sum)
                return true;
            if (cur.left != null) {
                queue.add(cur.left);
                eachtreeNodeSumQueue.add(cur.left.data + curSum);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                eachtreeNodeSumQueue.add(cur.right.data + curSum);
            }
        }
        return false;
    }

    int findTotalSumPath(TreeNode root, int sum) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> eachTreeNodeSumQueue = new LinkedList<>();
        queue.add(root);
        eachTreeNodeSumQueue.add(root.data);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curSum = eachTreeNodeSumQueue.poll();
            if (cur.left == null && cur.right == null && curSum == sum)
                count++;
            if (cur.left != null) {
                queue.add(cur.left);
                eachTreeNodeSumQueue.add(cur.left.data + curSum);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                eachTreeNodeSumQueue.add(cur.right.data + curSum);
            }
        }
        return count;
    }

    List<List<Integer>> printPathSum(TreeNode root, int sum) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null)
            return levelOrder;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumPath = new LinkedList<>();
        queue.add(root);
        sumPath.add(root.data);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curSum = sumPath.poll();
            List<Integer> list = new ArrayList<>();
            list.add(cur.data);
            if (cur.left == null && cur.right == null && curSum == sum)
                list.add(cur.data);
            if (cur.left != null) {
                queue.add(cur.left);
                sumPath.add(cur.left.data + curSum);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                sumPath.add(cur.right.data + curSum);
            }
        }
        return levelOrder;
    }

    int maxSumRootToLeafPath(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> eachTreeNodeSumQueue = new LinkedList<>();
        queue.add(root);
        eachTreeNodeSumQueue.add(root.data);
        int maxSum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curSum = eachTreeNodeSumQueue.poll();
            if (cur.left == null && cur.right == null)
                maxSum = Math.max(maxSum, curSum);
            if (cur.left != null) {
                queue.add(cur.left);
                eachTreeNodeSumQueue.add(cur.left.data + curSum);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                eachTreeNodeSumQueue.add(cur.right.data + curSum);
            }
        }
        return maxSum;
    }

    int sumOfPathNumbers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> eachTreeNodeSumQueue = new LinkedList<>();
        queue.add(root);
        eachTreeNodeSumQueue.add(root.data);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curSum = eachTreeNodeSumQueue.poll();
            if (cur.left == null && cur.right == null)
                ans += curSum;
            if (cur.left != null) {
                queue.add(cur.left);
                eachTreeNodeSumQueue.add(curSum * 10 + cur.left.data);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                eachTreeNodeSumQueue.add(curSum * 10 + cur.right.data);
            }
        }
        return ans;
    }

    boolean findPathSequence(TreeNode root, int[] sequence) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.data == sequence[level] && cur.left == null && cur.right == null)
                    return true;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            level++;
        }
        return false;
    }

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre == null)
                pre = cur;
            else
                pre.right = cur;
            cur = cur.right;
        }
        return pre;
    }
}


