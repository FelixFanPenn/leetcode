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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, root, 0);
        return res;
    }
    
    private void help(List<List<Integer>> res, TreeNode root, int l){
        if (root == null) return;
        if (l == res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(l).add(root.val);        
        help(res, root.left, l+1);
        help(res, root.right, l+1);
    }
}
