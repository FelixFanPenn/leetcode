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
http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
*/

class Solution {
    int post = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int right = inorder.length-1;
        post = right;
        return helper(inorder, postorder, 0, right);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        if (right < left) return null;
        
        TreeNode node = new TreeNode(postorder[post--]);
        if (right == left) return node;
        
        int index = search(inorder, node.val, left, right);
        node.right = helper(inorder, postorder, index+1, right);
        node.left = helper(inorder, postorder, left, index-1);
        return node;
    }
    
    public int search(int[] in, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (in[i] == target) return i;
        }
        return right;
    }
}
