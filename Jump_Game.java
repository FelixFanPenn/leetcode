public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            max--;
            if (max == -1) return false;
            max = Math.max(max, nums[i]);
        }
        return true;
    }
}