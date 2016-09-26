/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return help(root, 0) != -1;
    }
    
    private int help(TreeNode root, int h){
        if (root == null) return h;
        int left = help(root.left, h+1);
        if (left == -1) return -1;
        int right = help(root.right, h+1);
        if (right == -1) return -1;
        
        if (Math.abs(left - right) > 1) return -1;
        return left > right? left:right;
    }
}
