public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        if (sum % 2 == 1) return false;
        return helper(nums, nums.length-1, sum/2);
    }
    
    private boolean helper(int[] nums, int end, int sum){
        if (sum == 0) return true;
        if (end == -1) return false;
        if (nums[end] > sum) return helper(nums, end-1, sum);
        return helper(nums, end-1, sum-nums[end]) || helper(nums, end-1, sum);
    }
}
