public class Solution {
    public int totalHammingDistance(int[] nums) {
        int bitCount = 0, n = nums.length, sum = 0;
        
        for (int i = 0; i < 32; i++){
            bitCount = 0;
            for (int num : nums){
                if (((num >> i) & 1) == 1) bitCount++;
            }
            sum += bitCount * (n - bitCount);
        }
        
        return sum;
    }
}
