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
	public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            
            if (root.val > target) root = root.left;
            else root = root.right;
        }
        
        return closest;
    }
	/*
    public int closestValue(TreeNode root, double target) {
        int cur = root.val;
        TreeNode node = cur > target ? root.left : root.right;
        if (node == null) return root.val;
        int sub = closestValue(node, target);
        return Math.abs(target - root.val) > Math.abs(target - sub) ? sub : root.val ;
    }
    */
}