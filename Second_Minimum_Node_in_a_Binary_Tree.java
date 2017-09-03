/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    long m1 = Long.MAX_VALUE;
    long m2 = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        if (m2 == Long.MAX_VALUE) return -1;
        return (int)m2;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.val < m1) {
            m2 = m1;
            m1 = root.val;
        } else if (root.val < m2 && root.val != m1) {
            m2 = root.val;
        }
        helper(root.left);
        helper(root.right);
    }
}