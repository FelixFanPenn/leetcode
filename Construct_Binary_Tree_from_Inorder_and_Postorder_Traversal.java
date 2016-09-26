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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return help(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode help(int[] inorder, int[] postorder, int instart, int inend, int postart, int poend){
        if (instart > inend) return null;
        TreeNode root = new TreeNode(postorder[poend]);
        int i;
        for (i = inend; i >= instart; i--){
            if (inorder[i] == postorder[poend]) break;
        }
        
        root.left = help(inorder, postorder, instart, i-1, postart, i+postart-instart-1);
        root.right = help(inorder, postorder, i+1, inend, i+postart-instart, poend-1);   // url = http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
        return root;
    }
}
