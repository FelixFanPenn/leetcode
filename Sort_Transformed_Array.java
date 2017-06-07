public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int start = 0, end = nums.length-1, count = 0;
        int[] res = new int[nums.length];
        if (a < 0) {
            while (start <= end){
                int i = calc(nums[start], a, b, c);
                int j = calc(nums[end], a, b, c);
                if (i < j) {
                    res[count++] = i;
                    start++;
                } else {
                    res[count++] = j;
                    end--;
                }
            }
        } else {
            count = nums.length-1;
             while (start <= end){
                int i = calc(nums[start], a, b, c);
                int j = calc(nums[end], a, b, c);
                if (i > j) {
                    res[count--] = i;
                    start++;
                } else {
                    res[count--] = j;
                    end--;
                }
            }
        }
        return res;
    }
    
    public int calc(int n, int a, int b, int c){
        return a * n * n + b * n + c;
    }
}