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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    
    private int helper(TreeNode root, boolean leftChild){
        if (root == null) return 0;
        if (leftChild && root.left == null && root.right == null){
            return root.val;
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}
