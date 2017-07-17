public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length, max = 0, index = -1;
        List<Integer> res = new ArrayList<>();
        int[] count = new int[len];
        int[] pre = new int[len];
        Arrays.sort(nums);
        
        for (int i = 0; i < len; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            
            if (max < count[i]) {
                max = count[i];
                index = i;
            }
        }
        
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}