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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
    /*
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean validate(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }
    */
}