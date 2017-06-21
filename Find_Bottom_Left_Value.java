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
    public int findBottomLeftValue(TreeNode root) {
        int[] level = new int[1];
        int[] res = new int[1];
        res[0] = root.val;
        level[0] = 0;
        helper(root, level, res, 0);
        return res[0];
    }
    
    public void helper(TreeNode root, int[] level, int[] res, int l){
        if (root == null) return;
        if (l > level[0]) {
            res[0] = root.val;
            level[0] = l;
        }
        helper(root.left, level, res, l+1);
        helper(root.right, level, res, l+1);
    }
    
    
}