public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1; res[1] = -1;
        
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target){
            return res;
        }
        
        
        
        
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    
    public int findFirst(int[] nums, int target){
        int start = 0; int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            
            if (nums[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) return start;
        else {
            if (nums[end] == target) return end;
            else return -1;
        }
    }
    
    public int findLast(int[] nums, int target){
        int start = 0; int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            
            if (nums[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        else {
            if (nums[start] == target) return start;
            else return -1;
        }
    }
}

/*
public class Solution {
public int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
		int lo = 0, hi = nums.length - 1;

		//lo is the start index of target
		//hi is the end index of target
		while(nums[lo] < nums[hi]) {
			int mid = lo + (hi - lo)/2;
			if(nums[mid] > target) {//target is in the left half
				hi = mid - 1;
			} else if(nums[mid] < target) {// target is in the right half
				lo = mid + 1;
			} else {//find target, then need to find the start and end point
				if(nums[lo] == nums[mid]) {
					hi--;
				}else {
					lo++;
				}
			}
		}
		//check whether find the target number
		if(nums[lo] == nums[hi] && nums[lo]== target) {
			res[0] = lo;
			res[1] = hi;
		}
		
		return res;
	}
}
*/

