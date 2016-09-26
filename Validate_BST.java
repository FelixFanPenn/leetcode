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
        return help(root, Long.MAX_VALUE, Long.MIN_VALUE);    // THIS IS HOW JAVA REPRESENTS MAX AND MIN VALUE!
    }
    
    private boolean help(TreeNode root, long max, long min){
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return help(root.left, root.val, min) && help(root.right, max, root.val);
    }
}
