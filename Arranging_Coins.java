public class Solution {
    public int arrangeCoins(int n) {

        int l = 0, r = n;
        while (l <= r){
            int mid = (r-l) / 2 + l;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l-1;
    }
}