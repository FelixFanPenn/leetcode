class Solution {
    public int divide(int dividend, int divisor) {
        boolean b1 = dividend >= 0;
        boolean b2 = divisor >= 0;
        boolean isNeg = b1 ^ b2;
        
        long newDividend = Math.abs((long)dividend);
        long newDivisor = Math.abs((long)divisor);
        long res = 0;
        while (newDividend >= newDivisor) {
            long m = 1;
            long nd = newDivisor;
            while (newDividend >= (nd << 1)) {
                nd = nd << 1;
                m = m << 1;
            }
            res += m;
            newDividend -= nd;
        }
        
        return isNeg ? (int)(~res + 1) : res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }
}