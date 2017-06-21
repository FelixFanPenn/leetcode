public class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int i = 0, j = 0, k = 0;
        while (i < len-2) {
            while (i < len-2 && nums[i] >= nums[i+1]) {
                i++;
            }
            j = i+1;
            while (j < len-1 && nums[j] <= nums[j+1]) {
                j++;
            }
            k = j+1;
            while (k < len) {
                if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
                k++;
            }
            i = j+1;
        }   
        
        return false;
    }
}