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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean b1 = (s == null) ? false : isSubtree(s.right, t) || isSubtree(s.left, t) ;
        return sameTree(s, t) || b1;
    }
    
    public boolean sameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null && t != null || s != null && t == null) return false;
        return s.val == t.val && sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
}