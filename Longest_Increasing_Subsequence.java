public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] arr = new int[len];
        Arrays.fill(arr, 1);
        int max = 0;
        
        for (int i = 0; i < len; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    arr[i] = arr[i] > arr[j] + 1 ? arr[i] : arr[j] + 1;
                }
            }
            max = Math.max(max, arr[i]);
        }
        
        return max;
    }
}
