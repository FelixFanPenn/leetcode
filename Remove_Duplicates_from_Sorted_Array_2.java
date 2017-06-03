public class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = 0, count = 1;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[pre]) {
                if (count == 1) {
                    count++;
                    pre++;
                    swap(nums, pre, i);
                }
            } else {
                count = 1;
                pre++;
                swap(nums, pre, i);
            }
        }
        return pre+1;
    }
    
    public void swap(int[] nums, int l, int r){
        int a = nums[l];
        nums[l] = nums[r];
        nums[r] = a;
    }
}