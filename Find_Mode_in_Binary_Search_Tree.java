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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(map, root);
        
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Integer i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                list = new ArrayList<>();
            }
            if (max == map.get(i)) {
                list.add(i);
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    public void traverse(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) return;
        if (!map.containsKey(root.val)) {
            map.put(root.val, 0);
        }
        map.put(root.val, map.get(root.val)+1);
        
        traverse(map, root.left);
        traverse(map, root.right);
    }
}