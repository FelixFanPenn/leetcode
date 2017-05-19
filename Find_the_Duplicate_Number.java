public class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        
        int  l = 0, r = nums.length-1;
        while (l <= r){
            int mid = (l + r) / 2;
            int count = 0;
            for (int i : nums){
                if (i <= mid){
                    count++;
                }
            }
            
            if (count > mid) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}