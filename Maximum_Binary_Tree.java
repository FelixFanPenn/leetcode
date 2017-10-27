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
    
    // avg O(nlogn) worst case O(n^2) == > 6 5 4 3 2 1
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper (int[] nums, int left, int right) {
        if (left > right) return null;
        int index = -1, val = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (val < nums[i]) {
                val = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper (nums, left, index-1);
        node.right = helper (nums, index+1, right);
        return node;
    }

	// O(n)  iterative  
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        LinkedList<TreeNode> lklist = new LinkedList<>();
        TreeNode left = null;
        for (int num: nums){
            TreeNode cur = new TreeNode(num);
            while (!lklist.isEmpty() && lklist.peekFirst().val < cur.val){
                cur.left = lklist.pop();
            }
            
            if (!lklist.isEmpty()){
                lklist.peekFirst().right = cur;
            }
            lklist.push(cur);
        }
        
        return lklist.peekLast();
    }
}