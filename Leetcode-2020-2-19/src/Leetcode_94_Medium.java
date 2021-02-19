/*
* Leetcode_94. Binary Tree Inorder Traversal
* Given the root of a binary tree, return the inorder traversal of its nodes' values.
*
* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


class Solution {
    /*
     * My first method: No-Recursive
     * Time > 41.48%
     * Memory > 37.85%
     * */
/*    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = root;
        List<Integer> result = new ArrayList<Integer>();
        while ( currentNode != null || stack.size() != 0) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else {
                currentNode = stack.pop();
                result.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return result;

    }*/


    /*
     * My second method : Recursive
     * Time > 41.48%
     * Memory > 18.86%
     * */
     public List<Integer> inorderTraversal(TreeNode root) {
         Stack<TreeNode> stack = new Stack<TreeNode>();
         TreeNode currentNode = root;
         List<Integer> result = new LinkedList<Integer>();
         List<Integer> left;
         if (root == null) {
             return result;
         }
         else {
             result = inorderTraversal(root.left);
             result.add(root.val);
             List<Integer> temp = inorderTraversal(root.right);
             result.addAll(temp);
             return result;

         }


     }


}



