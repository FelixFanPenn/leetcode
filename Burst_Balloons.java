public class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] res = new int[nums.length][nums.length];
        
        for (int len = 0; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int k = start; k <= end; k++) {
                    int left = (start == 0) ? 1 : nums[start-1];
                    int right = (end == nums.length - 1) ? 1 : nums[end+1];
                    
                    int before = (start == k) ? 0 : res[start][k-1];
                    int after = (end == k) ? 0 : res[k+1][end];
                    
                    res[start][end] = Math.max(left * nums[k] * right + before + after, res[start][end]);
                }
                
            }
        }
        return res[0][nums.length-1];
    }
}