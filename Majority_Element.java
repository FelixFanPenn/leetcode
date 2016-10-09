public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        
        for (int i = 0; i < len; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                 map.put(nums[i], 1);
            }
        }
        
        for (int key : map.keySet()){
            if (map.get(key) > len/2) return key;
        }
        return 0;
    }
}
