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

/*
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] tmp = new int[nums.length];
        tmp[0] = 1;
        
        for (int i = 1; i < nums.length; i++){
            tmp[i] = tmp[i-1] * nums[i-1];
        }
        
        int[] tmp1 = new int[nums.length];
        tmp1[nums.length-1] = 1;
        
        for (int i = nums.length-2; i >= 0; i--){
            tmp1[i] = tmp1[i+1] * nums[i+1];
        }
        
        for (int i = 0; i < nums.length; i++){
            tmp[i] *= tmp1[i];
        }
        
        
        return tmp;
    }
}


*/
