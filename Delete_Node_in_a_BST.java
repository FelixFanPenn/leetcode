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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null && cur.val != key) {
            pre = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else if (cur.val < key) {
                cur = cur.right;
            } 
        }
        
        if (pre == null) {
            return delete(cur);
        } else if (pre.left == cur) {
            pre.left = delete(cur);
        } else {
            pre.right = delete(cur);
        }
        
        return root;
    }
    
    public TreeNode delete(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        TreeNode tmp = node.right;
        TreeNode pre = null;
        while (tmp.left != null) {
            pre = tmp;
            tmp = tmp.left;
        }
        
        tmp.left = node.left;
        
        if (node.right != tmp) {
            pre.left = tmp.right;
            tmp.right = node.right;
        }
        return tmp;
    }
}