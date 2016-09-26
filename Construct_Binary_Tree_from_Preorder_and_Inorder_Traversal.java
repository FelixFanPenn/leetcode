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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, preorder.length-1, 0);
    }
    
    private TreeNode help(int[] preorder, int[] inorder, int start, int end, int index){
        if (start > end || index >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[index]);
        int i;
        for (i = end; i >= start; i--){
            if (preorder[index] == inorder[i]) break;
        }
        
        root.left = help(preorder, inorder, start, i-1, index+1);
        root.right = help(preorder, inorder, i+1, end, index+i-start+1);   // index+i-start+1 ?????  url = http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
        return root;
    }
}
