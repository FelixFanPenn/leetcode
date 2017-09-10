class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        int max = 1, cur = 1, n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > n) {
                cur++;
                n = nums[i];
                max = Math.max(max, cur);
            } else {
                cur = 1;
                n = nums[i];
            }
        }
        return max;
    }
}