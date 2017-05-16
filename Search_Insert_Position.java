public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target){
            return 0;
        }
        
        int start = 0; int end = nums.length - 1;
        
        if (nums[end] < target){
            return nums.length;
        }
        
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] == target){
            return start;
        }
        
        return end;
        
    }
}
