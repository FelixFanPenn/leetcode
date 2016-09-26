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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        help(res, root, 0);
        int len = res.size();
        for (int i = 0; i < len; i++){
            if (i % 2 == 0) {
                Collections.reverse(res.get(i));        // only even row should be reversed
            }
        }
        return res;
    }
    
    private void help(List<List<Integer>> res, TreeNode root, int level){
        if (root == null) return;
        if (res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        help(res, root.right, level+1);
        help(res, root.left, level+1);
    }
}
