public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length, min = nums[len-1], max = nums[0], end = -2, beg = -1;
        
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i - 1]);
            if (max > nums[i]) end = i;
            if (min < nums[len - i - 1]) beg = len - i - 1;
        }
        
        
        return end - beg + 1;
    }
}