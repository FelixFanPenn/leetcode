public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] res = new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++){
            if (i == 0){
                res[0] = nums[i];
            } else if (i == 1){
                res[1] = Math.max(nums[0], nums[1]);
            } else {
                res[i] = Math.max(res[i-1], res[i-2] + nums[i]);
            }
        }
        
        int[] ret = new int[nums.length-1];
        for (int i = 1; i < nums.length; i++){
            if (i == 1){
                ret[0] = nums[i];
            } else if (i == 2){
                ret[1] = Math.max(nums[1], nums[2]);
            } else {
                ret[i-1] = Math.max(ret[i-2], ret[i-3] + nums[i]);
            }
        }
        return Math.max(res[nums.length-2], ret[nums.length-2]);
    }
}
