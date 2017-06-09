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
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        
        helper(root,res);
        return res[0];
        
    }
    
    public boolean helper(TreeNode root, int[] res){
        if (root == null) return true;
        
        boolean b1 = (root.left == null || helper(root.left, res));
        boolean b2 = (root.right == null || helper(root.right, res));
        if (b1 && b2) {
            if (root.left != null) {
                if (root.left.val != root.val) return false;
            }
            
            if (root.right != null) {
                if (root.right.val != root.val) return false;
            }
            res[0]++;
            return true;
        } else {
            return false;
        }
    }
    
}