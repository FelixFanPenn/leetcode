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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int[] res = new int[1];
        
        helper(root, map, res);
        return res[0];
    }
    
    public int helper(TreeNode root, Map<TreeNode, Integer> map, int[] res) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int left = helper(root.left, map, res);
        int right = helper(root.right, map, res);
        
        res[0] = Math.max(res[0], left + right);
        map.put(root, Math.max(left, right) + 1);
        return Math.max(left, right) + 1;
    }
}