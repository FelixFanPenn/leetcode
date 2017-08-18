class Solution {
    /*
    http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    
    
    
    */
    
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] tails = new int[len];
        int size = 0;
        
        for (int i = 0; i < len; i++) {
            int l = 0, r = size;
            while (l != r) {
                int mid = (l + r) / 2;
                if (tails[mid] < nums[i]) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
            tails[l] = nums[i];
            if (l == size) size++;
        }
        
        return size;
    }
}