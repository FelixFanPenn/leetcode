public class Solution {
    public int splitArray(int[] nums, int m) {
        
        long sum = 0; int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        
        return (int)binarySearch(nums, sum, max, m);
    }
    
    public long binarySearch(int[] nums, long sum, long max, int m) {
        long left = max, right = sum;
        
        //while (left + 1 < right) {
        while (left < right) {
            long mid = (left + right) / 2;
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right;
        //return isValid(nums, m, left) ? left : right;
    }
    
    public boolean isValid(int[] nums, int m, long res) {
        int cur = 0;
        int count = 1;
        for (int i : nums) {
            cur += i;
            if (cur > res) {
                count++;
                cur = i;
                if (count > m) return false;
            }
        }
        return true;
    }
}