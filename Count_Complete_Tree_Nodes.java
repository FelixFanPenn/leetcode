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
    public int countNodes(TreeNode root) {
        //  runtime O(log(n)^2)
        if (root == null) return 0;
        TreeNode leftChild = root;
        TreeNode rightChild = root;
        int height = 0;
        while(rightChild != null){
            leftChild = leftChild.left;
            rightChild = rightChild.right;
            height++;
        }
        if (leftChild == null) return (1 << height)-1;
        return 1 + countNodes(root.left) + countNodes(root.right);
      
        
        /*
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
        */
    }
}
