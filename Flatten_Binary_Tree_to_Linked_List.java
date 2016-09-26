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
    private TreeNode pre = null;
    public void flatten(TreeNode root) {   ///post order traversal!!! just just just BRILLIANT
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }
}
