public class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);
        
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum == c) return true;
            if (sum > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }
}