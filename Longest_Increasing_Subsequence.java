public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] res = new int[len+1];
        res[0] = 0;
        
        for (int i = 0; i < len; i++){
            res[i+1] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) {
                    res[i+1] = Math.max(res[i+1], 1+res[j+1]);
                }
            }
        }
        
        int max = 0;
        for (int i : res){
            max = Math.max(max, i);
        }
        
        return max;
    }
}

/*
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
*/