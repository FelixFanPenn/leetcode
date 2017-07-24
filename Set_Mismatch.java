public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                res[0] = num;
            } else {
                map.put(num, 1);
            }
        }
        
        for (int i = 0; i <= len; i++) {
            if (!map.containsKey(i)) {
                res[1] = i;
            }
        }
        
        return res;
    }
}