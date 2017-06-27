public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[len-1] * nums[len-2] * nums[len-3];
        int b = nums[len-1] * nums[1] * nums[0];
        return a > b ? a : b;
    }
}