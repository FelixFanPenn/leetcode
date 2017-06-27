public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        
        /*
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    if (dp[i] == 3) return true;
                }
            }
        }
        return false;
        */
        
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for (int i : nums) {
            if (i <= min1) {
                min1 = i;
            } else if (i <= min2) {
                min2 = i;
            } else {
                return true;
            }
        }
        return false;
    }
}