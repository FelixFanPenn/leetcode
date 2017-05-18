public class Solution {
    public int majorityElement(int[] nums) {
        int cur = nums[0], count = 1;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == cur){
                count++;
            } else {
                if (count == 0){
                    cur = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        
        return cur;
    }
}
/*
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
*/
