// https://discuss.leetcode.com/topic/2633/share-my-o-n-time-o-1-space-solution/2
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        
        int q = partition(nums);

        
        for (int i = 0; i < q; i++){
            int tmp = Math.abs(nums[i]);
            if (tmp <= q)
                nums[tmp-1] = nums[tmp-1] < 0? nums[tmp-1] : -nums[tmp-1] ;
        }
        
        for (int i = 0; i < q; i++){
            if (nums[i] > 0) return i+1;
        }
        return q+1;
    }
    
    public int partition(int[] nums){
        int l = 0, len = nums.length;
        
        for (int i = 0; i < len; i++){
            if (nums[i] > 0){
                swap(nums, i, l++);
            }
        }
        
        return l;
    }
    
    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}