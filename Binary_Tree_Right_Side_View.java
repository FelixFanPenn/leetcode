/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                if (i == size-1) {
                    res.add(node.val);
                }
                if (node.left != null)
                    dq.offer(node.left);
                if (node.right != null)
                    dq.offer(node.right);
            }
        }
        return res;
    }
    
    /*
    public void helper(List<Integer> res, TreeNode node, int level) {
        if (node == null)
            return;
        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, node.val);
        }
        helper(res, node.left, level+1);
        helper(res, node.right, level+1);
    }
    */
}