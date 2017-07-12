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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) return list;
        if (root.left != null || root.right != null) {
            list.add(root.val);
        }
        
        leftBoundary(root.left, list);
        leaves(root, list);
        rightBoundary(root.right, list);
        
        return list;
    }
    
    public void leftBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        
        list.add(root.val);
        if (root.left == null) leftBoundary(root.right, list);
        else leftBoundary(root.left, list);
    }
    
    public void rightBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        
        if (root.right == null) rightBoundary(root.left, list);
        else rightBoundary(root.right, list);
        list.add(root.val);
    }
    
    public void leaves(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            leaves(root.left, list);
            leaves(root.right, list);
        }
    }
    /*
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) return list;
        if (root.left != null || root.right != null) {
            list.add(root.val);
        }
        
        helper(root.left, list, true, false);
        helper(root.right, list, false, true);
        return list;
    }
    
    public void helper(TreeNode root, List<Integer> list, boolean left, boolean right) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        
        if (left) list.add(root.val);
        
        helper(root.left, list, left && root.left != null, right && root.right == null);
        helper(root.right, list, left && root.left == null, right && root.right != null);
        if (right) list.add(root.val);
    }
    */
}