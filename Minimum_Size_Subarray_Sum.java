public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, start = 0, end = 0, len = nums.length;
        int min = Integer.MAX_VALUE;
        
        while (end <= len){
            if (sum >= s){
                min = Math.min(min, end-start);
                sum -= nums[start++];
                
            } else {
                if (end == len) break;
                sum += nums[end];
                end++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}