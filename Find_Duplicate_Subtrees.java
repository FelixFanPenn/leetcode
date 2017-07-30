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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        traverse(res, new HashMap<>(), root);
        return res;
    }
    
    public String traverse(List<TreeNode> res, Map<String, Integer> map, TreeNode root) {
        if (root == null) return "null";
        String serial = root.val + "," + traverse(res, map, root.left) + "," + traverse(res, map, root.right);
        if (map.containsKey(serial)) {
            if (map.get(serial) == 1) res.add(root);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}