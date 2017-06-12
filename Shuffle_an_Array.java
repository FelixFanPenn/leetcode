import java.util.Random;

public class Solution {
    
    int[] res;
    Random random;
    
    public Solution(int[] nums) {
        res = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return res;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] a = res.clone();

        for (int i = 0; i < res.length; i++) {
            int r = random.nextInt(i+1);
            swap(a, i, r);
        }
        return a;
    }
    
    public void swap(int[] res, int i, int j) {
        int k = res[i];
        res[i] = res[j];
        res[j] = k;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */