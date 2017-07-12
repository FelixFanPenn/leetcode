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
    /*
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<List<Integer>> lists = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        
        traverse(root, lists, 0);
        
        for (int i = 0; i < lists.size(); i++) {
            double sum = 0, size = lists.get(i).size();
            for (int j : lists.get(i)) {
                sum += (j * 1.0) / (size * 1.0);
            }
            res.add(sum);
        }
        return res;
        
    }
    
    public void traverse(TreeNode root, List<List<Integer>> lists, int level) {
        if (root == null) return;
        if (level == lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        
        lists.get(level).add(root.val);
        traverse(root.left, lists, level+1);
        traverse(root.right, lists, level+1);
    }
    */
    
    public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    
    if(root == null) return result;
    q.add(root);
    while(!q.isEmpty()) {
        int n = q.size();
        double sum = 0.0;
        for(int i = 0; i < n; i++) {
            TreeNode node = q.poll();
            sum += node.val;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        result.add(sum / n);
    }
    return result;
}
}