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
    
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        maxPathSumHelper(root);
        return max;
    }
    
    public int maxPathSumHelper(TreeNode root){
        if (root == null) return 0;
        
        int l = Math.max(maxPathSumHelper(root.left), 0);
        int r = Math.max(maxPathSumHelper(root.right), 0);
        
        max = Math.max(max, l + r + root.val);
        return Math.max(l, r) + root.val;
    }
}