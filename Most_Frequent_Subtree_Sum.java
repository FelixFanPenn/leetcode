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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(map, root);
        
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (max < map.get(i)) max = map.get(i);
        }
        
        for (Integer i : map.keySet()) {
            if (map.get(i) == max) list.add(i);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    public int helper(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) return 0;
        int l = helper(map, root.left);
        int r = helper(map, root.right);
        int sum = l + r + root.val;
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum)+1);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }
}