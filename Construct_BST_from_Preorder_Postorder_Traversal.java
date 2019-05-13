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
    public TreeNode bstFromPreorder(int[] pre) {
        if (pre.length == 0) {
            return null;
        }
        return h(pre, 0, pre.length-1);
    }
    
    private TreeNode h(int[] pre, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode node = new TreeNode(pre[l]);
        int i;
        for (i = l+1; i <= r; i++) {
            if (pre[i] > pre[l]) {
                break;
            }
        }
        node.left = h(pre, l+1, i-1);
        node.right = h(pre, i, r);
        return node;
    }
}