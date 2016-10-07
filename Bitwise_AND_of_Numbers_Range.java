public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        /*
        while (n > m){
            n = n & (n-1);
        }
        return n & m;
        */
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
