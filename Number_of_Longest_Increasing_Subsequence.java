class Solution {
    public int findNumberOfLIS(int[] nums) {
        int l = nums.length, max = 0, res = 0;
        int[] len = new int[l];
        int[] numbers = new int[l];
        
        for (int i = 0; i < l; i++) {
            len[i] = 1;
            numbers[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        numbers[i] += numbers[j];
                    } else if (len[i] < len[j] + 1) {
                        numbers[i] = numbers[j];
                        len[i] = len[j] + 1;
                    }
                }
            }
            if (max == len[i]) {
                res += numbers[i];
            } else if (max < len[i]) {
                max = len[i];
                res = numbers[i];
            }
        }
        return res;
    }
}