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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int findPath(TreeNode root, int sum){
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        if (sum == root.val) res = 1;
        
        return res + findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
        
    }
}