public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 

    /*
    The original problem statement is equivalent to:
    Find a subset of nums that need to be positive, and the rest of them negative, 
    such that the sum is equal to target


    */

    /*
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, S, new HashMap<String, Integer>(), 0, 0);
    }
    
    public int helper(int[] nums, int S, Map<String, Integer> map, int cur, int sum) {
        
        if (cur == nums.length) {
            if (S == sum) return 1;
            return 0;
        }
        
        String key = cur + "->" + sum;
        if (map.containsKey(key)) return map.get(key);
        
        int sub = helper(nums, S, map, cur+1, sum - nums[cur]);
        int add = helper(nums, S, map, cur+1, sum + nums[cur]);
        map.put(key, sub+add);
        return sub+add;
    }
    */
}