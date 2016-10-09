public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if (nums[left] < nums[mid]){
                if (nums[mid] > nums[right]){
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] < nums[right]){
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
