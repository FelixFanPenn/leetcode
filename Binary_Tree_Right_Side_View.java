//**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {     /// just use preorder traversal!!! use integer variable to keep track of levels
        List<Integer> res = new ArrayList<Integer>();
        help(root, res, 0);
        return res;
    }
    
    private void help(TreeNode root, List<Integer> res, int level){
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);
        }
        help(root.right, res, level+1);
        help(root.left, res, level+1);
    }
}
