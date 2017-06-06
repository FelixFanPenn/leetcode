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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        /*
        if (root == null || root.left == null) {
            return root;
        } else {
            TreeNode tmp = root.left;
            TreeNode res = upsideDownBinaryTree(root.left);
            tmp.left = root.right;
            tmp.right = root;
            root.left = null;
            root.right = null;
            return res;
            
        }
        */
        
        TreeNode pre = null, next = null, tmp = null;
        while (root != null) {
            next = root.left;
            root.left = tmp;
            tmp = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}

