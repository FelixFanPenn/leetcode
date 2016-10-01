public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        int pow = 0;
        
        for (int i = 1; i <= num; i++){
            if (Math.pow(2, pow+1) <= i) pow++;
            res[i] = 1 + res[i - (int)Math.pow(2, pow)];
        }
        return res;
    }
}
