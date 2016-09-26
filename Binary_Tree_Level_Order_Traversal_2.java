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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        help(root, 0, res);
        reverse(res);
        Collections.reverse(res);   // it reverses the list but returns null!!!!!!
        return res;
    }
    
    private void help(TreeNode root, int l, List<List<Integer>> res){
        if (root == null) return;
        if (res.size() == l){
            res.add(new ArrayList<>());
        }
        res.get(l).add(root.val);
        help(root.left, l+1, res);
        help(root.right, l+1, res);
    }

}
