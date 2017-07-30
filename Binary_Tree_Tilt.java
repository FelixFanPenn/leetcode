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
    public int findTilt(TreeNode root) {
        int[] res = new int[1];
        postOrder(root, res);
        return res[0];
    }
    
    public int postOrder(TreeNode root, int[] res) {
        if (root == null) return 0;
        int l = postOrder(root.left, res);
        int r = postOrder(root.right, res);
        res[0] += Math.abs(l - r);
        return l + r + root.val;
    }
}