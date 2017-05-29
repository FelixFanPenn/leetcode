public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % 2 == 1) return false;
        
        boolean[] res = new boolean[sum/2 + 1];
        res[0] = true;
        
        for (int i = 0; i < nums.length; i++){
            for (int j = res.length-1; j > 0; j--){
                if (j >= nums[i]) {
                    res[j] = res[j] || res[j-nums[i]];
                }
            }
        }
        
        return res[sum/2];
    }
    
    
    public int getSum(int[] nums){
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        return sum;
    }
}

/*
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % 2 == 1) return false;
        
        boolean[][] res = new boolean[nums.length + 1][sum/2 + 1];
        
        for (int i = 0; i < res.length; i++){
            res[i][0] = true;
        }
        
        for (int i = 1; i < res.length; i++){
            for (int j = 1; j < res[0].length; j++){
                if (j >= nums[i-1]) {
                    res[i][j] = res[i-1][j] || res[i-1][j-nums[i-1]];
                } else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return res[res.length-1][sum/2];
    }
    
    public int getSum(int[] nums){
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        return sum;
    }
}

*/

/*
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        if (sum % 2 == 1) return false;
        return helper(nums, nums.length-1, sum/2);
    }
    
    private boolean helper(int[] nums, int end, int sum){
        if (sum == 0) return true;
        if (end == -1) return false;
        if (nums[end] > sum) return helper(nums, end-1, sum);
        return helper(nums, end-1, sum-nums[end]) || helper(nums, end-1, sum);
    }
}
*/
