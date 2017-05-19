public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = 0;
        while (l < r){
            int m = Math.min(height[l], height[r]);
            max = Math.max(max, (r-l) * m);
            
            if (m == height[l]) {
                l++;
            } else {
                r--;
            }
            
        }
        return max;
    }
}