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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        } else {
            helper(root, v, d-1);
            return root;
        }
    }
    
    public void helper(TreeNode root, int v, int d) {
        if (root == null) return;
        if (d == 1) {
            TreeNode node1 = new TreeNode(v);
            TreeNode node2 = new TreeNode(v);
            TreeNode l = root.left, r = root.right;
            root.left = node1;
            root.right = node2;
            node1.left = l;
            node2.right = r;
        } else {
            helper(root.left, v, d-1);
            helper(root.right, v, d-1);
        }
    }
}