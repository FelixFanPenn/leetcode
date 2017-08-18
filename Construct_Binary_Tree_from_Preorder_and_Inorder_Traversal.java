/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
*/

class Solution {
    int pre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int right = inorder.length-1;
        return helper(inorder, preorder, 0, right);
    }
    
    public TreeNode helper(int[] inorder, int[] preorder, int left, int right) {
        if (right < left) return null;
        TreeNode node = new TreeNode(preorder[pre++]);
        if (left == right) return node;
        int in = search(inorder, node.val, left, right);
        node.left = helper(inorder, preorder, left, in-1);
        node.right = helper(inorder, preorder, in+1, right);
        return node;
    }
    
    public int search(int[] in, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (in[i] == target) return i;
        }
        return right;
    }
}