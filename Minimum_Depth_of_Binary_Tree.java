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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);    // a node with only one child is NOT a leaf
        if (root.right == null) return 1 + minDepth(root.left);
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}
