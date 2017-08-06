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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int l = 0, r = nums.length-1;
        return helper(nums, l, r);
    }
    
    public TreeNode helper(int[] nums, int l, int r) {
        if (r < l) return null;
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = helper(nums, l, maxIndex-1);
        node.right = helper(nums, maxIndex+1, r);
        return node;
    }
}
