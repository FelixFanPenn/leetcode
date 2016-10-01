public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                res[i] = nums[i];
            } else if (i == 1){
                res[i] = Math.max(nums[1], nums[0]);
            } else {
                res[i] = Math.max(res[i-1], res[i - 2] + nums[i]);
            }
        }
        return res[nums.length-1];
    }
}
