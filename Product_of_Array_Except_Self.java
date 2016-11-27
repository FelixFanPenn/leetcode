public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        
        for (int i = 1; i < len; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        
        int h = nums[len-1];
        for (int i = len-2; i >= 0; i--){
            res[i] = res[i] * h;
            h *= nums[i];
        }
        return res;
    }
}
