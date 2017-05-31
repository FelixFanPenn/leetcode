public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length, red = 0, blue = len-1;
        
        for (int i = 0; i <= blue; i++){
            if (nums[i] == 0) {
                switchNumbers(nums, i, red++);
            } else if (nums[i] == 2){
                switchNumbers(nums, i--, blue--); // AFTER SWAPPING, CONSIDER THIS POSITION AGAIN
            }
        }
        
        
        /*  counting sort
        int[] count = new int[3];
        for (int i : nums){
            count[i]++;
        }
        int idx = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < count[i]; j++){
                nums[idx++] = i;
            }
        }
        */
    }
    
    public void switchNumbers(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}