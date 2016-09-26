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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return help(nums, 0, nums.length-1);      // array is .length!!!
    }
    
    private TreeNode help(int[] nums, int left, int right){
        if (left > right) return null;
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, left, mid-1);
        node.right = help(nums, mid+1, right);
        return node;
    }
}
