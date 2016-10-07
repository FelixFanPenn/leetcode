public class Solution {
    public int divide(int dividend, int divisor) {
        int sign1 = (dividend < 0)?-1:1;
        int sign2 = (divisor < 0)?-1:1;
        boolean isNegative = (sign1 == sign2) ? false : true;
        
        long newdividend = Math.abs((long)dividend), newdivisor = Math.abs((long)divisor);
        long ans = 0;
        
        while(newdividend >= newdivisor){
            long tmp = newdivisor;
            long m = 1;
            while(newdividend >= (tmp << 1)){
                m <<= 1;
                tmp <<= 1;
            }
            newdividend -= tmp;
            ans += m;
        }
        return isNegative ? (int) ~ans + 1 : ans > Integer.MAX_VALUE? Integer.MAX_VALUE : (int)ans;
    }
}

/*
Finally, we gotta check if the sign is positive or negative. If it is negative, then we apply negation ~result + 1 (two's complement) to get the negative result (why not just result * -1 ? Well, critics might say you use multiplication -_-!!! (lol jk). Also make sure to check if result is overflow, because you know, leetcode is pretty strict to corner cases as well.
*/
