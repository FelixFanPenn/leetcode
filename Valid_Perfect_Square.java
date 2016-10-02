public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        
        long low = 1, high = num;
        while(low + 1 < high){
            long mid = (low + high)/2;
            if (mid * mid == num) return true;
            else if (mid * mid > num) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low * low == num || high * high == num;
    }
}
