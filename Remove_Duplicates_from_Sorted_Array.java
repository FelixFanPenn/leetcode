public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[len] != nums[i]){
                nums[len+1] = nums[i];
                len++;
            }
        }
        return len+1;
    }
}
