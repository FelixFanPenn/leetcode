public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int max = Integer.MAX_VALUE;
        while ((max & m) != (max & n)) {
            max <<= 1;
        }
        return max & m;
    }
}