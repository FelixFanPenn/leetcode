public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++){
            sum = Math.max(sum, 0) + nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
