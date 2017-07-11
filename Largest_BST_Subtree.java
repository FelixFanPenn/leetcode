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
    public int largestBSTSubtree(TreeNode root) {
        if (isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return count(root);
        }
        
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    public boolean isValid(TreeNode root, int max, int min) {
        if (root == null) return true;
        if (root.val < max && root.val > min) 
            return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
        else return false;
    }
    
    public int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + count(node.left) + count(node.right);
    }
}