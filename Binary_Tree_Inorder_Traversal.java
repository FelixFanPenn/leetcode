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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }
    
    private void help(TreeNode root, List<Integer> res){
        if (root == null) return;
        help(root.left, res);
        res.add(root.val);
        help(root.right, res);
    }
}
