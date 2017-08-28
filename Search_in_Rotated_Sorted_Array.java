public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length-1;
        
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
               if (target <= nums[r] || nums[mid] > nums[r]) {
                   l = mid+1;
               } else {
                   r = mid-1;
               }
            } else {
                if (target >= nums[l] || nums[mid] < nums[r]) {
                   r = mid-1;
               } else {
                   l = mid+1;
               }
            }
        }
        return nums[l] == target ? l : -1;
    }
}

/*
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length-1;
        
        while (l + 1 < r){
            int mid = (l + r) / 2;
            
            if (target == nums[mid]) return mid;
            
            if (nums[mid] >= nums[l] && nums[mid] <= nums[r]) {
                if (target > nums[mid]) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else if (nums[mid] >= nums[l] && nums[mid] >= nums[r]){
                
                if (target > nums[mid] || target < nums[l]) {
                    l = mid;
                } else {
                    r = mid;
                }
                
            } else {
                
                if (nums[l] <= target || target < nums[mid]){
                    r = mid;
                } else {
                    l = mid;
                }
                
            }
            
        }
        
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}
*/