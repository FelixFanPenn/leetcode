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
    public List<List<String>> printTree(TreeNode root) {
        int dep = getMaxDep(root);
        int wid = (1 << dep) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < dep; i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < wid; j++) {
                tmp.add("");
            }
            res.add(tmp);
        }
        
        addWord(root, res, 0, 0, wid-1);
        return res;
    }
    
    public void addWord(TreeNode root, List<List<String>> res, int level, int l, int r) {
        if (root == null) return;
        int mid = (l + r) / 2;
        res.get(level).set(mid, "" + root.val);
        
        addWord(root.left, res, level+1, l, mid-1);
        addWord(root.right, res, level+1, mid+1, r);
    }
    
    public int getMaxDep(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getMaxDep(root.left), getMaxDep(root.right));
    }
}