/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean checkEqualTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        helper(map, root);
        for (TreeNode node : map.keySet()) {
            if (map.get(root) == 2 * map.get(node) && root != node) return true;
        }
        return false;
    }
    
    public int helper(Map<TreeNode, Integer> map, TreeNode root) {
        if (root == null) return 0;
        int left = helper(map, root.left);
        int right = helper(map, root.right);
        map.put(root, left + right + root.val);
        return left + right + root.val;
    }
}