public class Solution {
    /*
    public int findTargetSumWays(int[] nums, int S) {
        int[] res = new int[1];
        dfs(nums, S, res, 0);
        return res[0];
    }
    
    public void dfs(int[] nums, int S, int[] res, int cur) {
        if (S == 0 && cur == nums.length) {
            res[0]++;
            return;
        }
        if (cur == nums.length) return;
        
        dfs(nums, S - nums[cur], res, cur+1);
        dfs(nums, S + nums[cur], res, cur+1);
    }
    */
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
}