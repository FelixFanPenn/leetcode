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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        return helper(root, root.val, 1);
    }
    
    public int helper(TreeNode root, int parent, int len) {
        if (root == null) return len;
        if (root.val - 1 == parent) {
            int l = helper(root.left, root.val, len+1);
            int r = helper(root.right, root.val, len+1);
            return Math.max(1+len, Math.max(l, r));
        } else {
            int l = helper(root.left, root.val, 1);
            int r = helper(root.right, root.val, 1);
            return Math.max(l, r);
        }
    }
}