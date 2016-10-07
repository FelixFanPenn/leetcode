public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        
        for (int i = 31; i >= 0; i--, n >>= 1){  //reverse!
            r |= ((n & 1) << i);   // 
        }
        return r;
    }
}
