public class Solution {
    
    Random rand = new Random();
    int[] cand;
    public Solution(int[] nums) {
        cand = nums;
    }
    
    public int pick(int target) {
        int count = 0, res = -1;
        for (int i = 0; i < cand.length; i++) {
            if (target == cand[i]) {
                count++;
                if (rand.nextInt() % count == 0) res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */