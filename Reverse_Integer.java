public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = -x;
        }
        
        int res = 0;
        while(x > 0){
            int remainder = x % 10;
            int tmp = 10 * res + remainder;
            if (tmp/10 != res) return 0;
            res = tmp;
            x /= 10;
        }
        
        return isNeg? -res : res;
    }
}
