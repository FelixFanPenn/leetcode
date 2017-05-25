public class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0], sum = 0;
        
        for (int i : nums){
            min = Math.min(min, i);
        }
        
        for (int i : nums){
            sum += (i - min);
        }
        
        return sum;
    }
}