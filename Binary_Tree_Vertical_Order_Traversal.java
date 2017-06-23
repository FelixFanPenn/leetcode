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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        q1.offer(root); q2.offer(0);
        
        while (!q1.isEmpty()) {
            int tmp = q2.poll();
            TreeNode node = q1.poll();
            
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<Integer>());
            }
            map.get(tmp).add(node.val);
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
            
            if (node.left != null) {
                q1.add(node.left);
                q2.add(tmp-1);
            }
            
            if (node.right != null) {
                q1.add(node.right);
                q2.add(tmp+1);
            }
            
        }
        
        for (int i = min; i <= max; i++) {
            list.add(map.get(i));
        }
        return list;
    }
}