/*
* Leetcode 103. Binary Tree Zigzag Level Order Traversal
* Given a binary tree, return the zigzag level order traversal of its nodes' values.
* (ie, from left to right, then right to left for the next level and alternate between).
。*/


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */




/*
* Time > 98.74%
* Memory > 93.95%
* */
class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        int numOfRow = 1;
        int currentNumOfRow = 0;
        int i = 0;
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean flag = true;
        if (root == null) {
            return result;
        }

        deque.addLast(root);
        while(deque.size() > 0) {
            while(i < numOfRow) {
                root = deque.pollFirst();
                if (root.left != null) {
                    deque.addLast(root.left);
                    currentNumOfRow++;
                }
                if (root.right != null) {
                    deque.addLast(root.right);
                    currentNumOfRow++;
                }
                i++;
                temp.add(root.val);





            }
            if (!flag) {
                Collections.reverse(temp);
            }
            result.add(temp);
            i = 0;
            temp = new ArrayList<Integer>();
            numOfRow = currentNumOfRow;
            currentNumOfRow = 0;
            flag = !flag;

        }
        return result;


    }
}