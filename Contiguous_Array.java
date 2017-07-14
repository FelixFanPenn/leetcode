public class Solution {
    public int findMaxLength(int[] nums) {
        int[] diff = new int[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        map.put(0, 0);
        
        for (int i = 1; i <= nums.length; i++) {
            diff[i] = diff[i-1] + ((nums[i-1] == 0) ? -1 : 1);
            if (!map.containsKey(diff[i])) {
                map.put(diff[i], i);
            } else {
                max = Math.max(max, i - map.get(diff[i]));
            }
        }
        
        return max;
        
    }
}