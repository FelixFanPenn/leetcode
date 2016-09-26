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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        help(root, res);
        return res;
    }
    
    private void help(TreeNode root, List<Integer> res){
        if (root == null) return;
        help(root.left, res);
        help(root.right, res);
        res.add(root.val);
    }
}
