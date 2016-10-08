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
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        int sum = 0;
        for (int i = 0; i < res.size(); i++){
            sum += res.get(i);
        }
        return sum;
    }
    
    private void dfs(TreeNode root, List<Integer> res, int sum){
        if (root == null){
            return;
        } else {
            sum = sum * 10 + root.val;
            if (root.left == null && root.right == null){
                res.add(sum);
                return;
            } else {
                if (root.left != null){
                    dfs(root.left, res, sum);
                }
                if (root.right != null){
                    dfs(root.right, res, sum);
                }
                return;
            }
        }
    }
}
