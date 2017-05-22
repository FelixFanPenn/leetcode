public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length-1, tmp;
        
        while (l + 1 < r){
            int mid = (r - l) / 2 + l;
            
            if (nums[mid] < nums[r]){
                r = mid;
            } else if (nums[mid] > nums[r]){
                l = mid+1;
            } else {
                r--;
            }
            
        }
        return Math.min(nums[l], nums[r]);
        
    }
}