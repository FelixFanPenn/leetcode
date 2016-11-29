public class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length-1;
        
        while (j <= k){
            if (nums[j] == 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            } else if (nums[j] == 2){
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                k--;
            } else {
                j++;
            }
        }
    }
}
