public class Solution {
    public int jump(int[] nums) {
        int jump = 0, len = nums.length, curEnd = 0, curFar = 0;
        
        for (int i = 0; i < len-1; i++){
            curFar = Math.max(curFar, i+nums[i]);
            if (i == curEnd) {
                jump++;
                curEnd = curFar;
            }
        }
        return jump;
    }
}