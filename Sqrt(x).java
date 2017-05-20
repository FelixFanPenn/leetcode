public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x;
        
        while (l <= r){
            int mid = (r - l) / 2 + l;
       
            int f = x / mid;
            if (f == mid) return mid;
            else if (f < mid){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return r;
    }
}