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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        String str = "";
        help(root, str, res);
        return res;
    }
    
    private void help(TreeNode root, String str, List<String> res){
        if (root == null) return;
        if (root.left == null && root.right == null) {
            str = str + (Integer.toString(root.val));
            res.add(str);
            return;
        } else {
            str = str + (Integer.toString(root.val) + "->");
            help(root.left, str, res);
            help(root.right, str, res);
            return;
        }
    }
}
