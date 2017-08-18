/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        traverse(root, res, "");
        return res;
    }
    
    public void traverse(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }
        
        traverse(root.left, res, s + root.val + "->");
        
        traverse(root.right, res, s + root.val + "->");
        
    }
}
