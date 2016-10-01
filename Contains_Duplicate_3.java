public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if (len < 2 || k < 1 || t < 0) return false;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < len; i++){
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < len-1; i++){
            for (int j = i + 1; j < len; j++){
                if (nums[j] - nums[i] <= t && nums[j] - nums[i] > 0){   // nums[j] - nums[i] == 0 has been checked at the first for loop
                    if (Math.abs(map.get(nums[i]) - map.get(nums[j])) <= k){
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
