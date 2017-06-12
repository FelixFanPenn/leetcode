public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1, cur = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur == k) {
                res = i+1;
            } else if (map.containsKey(cur - k)) {
                res = Math.max(res, i - map.get(cur - k));
            } 
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            }
        }
        return res == -1 ? 0 : res ;
    }
}