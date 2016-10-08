public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int res = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++){
            int mx = curMax, mn = curMin;
            curMax = Math.max(Math.max(mx * nums[i], mn * nums[i]), nums[i]);
            curMin = Math.min(Math.min(mx * nums[i], mn * nums[i]), nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
