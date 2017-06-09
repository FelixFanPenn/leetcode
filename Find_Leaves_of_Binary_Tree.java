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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(res, root);
        return res;
    }
    
    public int height(List<List<Integer>> res, TreeNode root){
        if (root == null) return 0;
        int level = Math.max(height(res, root.left), height(res, root.right));
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        
        return level+1;
    }
    
    /*
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (true) {
            List<Integer> tmp = new ArrayList<>();
            find(root, null, tmp, true);
            if (tmp.size() == 0) break;
            else {
                res.add(tmp);
                if (tmp.size() == 1 && tmp.get(0) == root.val) break;
            }
        }
        return res;
    }
    
    public void find(TreeNode root, TreeNode pre, List<Integer> res, boolean isLeft) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            if (pre == null) return;
            if (isLeft) pre.left = null;
            if (!isLeft) pre.right = null;
            return;
        }
        find(root.left, root, res, true);
        find(root.right, root, res, false);
    }
    */
}