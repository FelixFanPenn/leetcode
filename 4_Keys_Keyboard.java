public class Solution {
    public int maxA(int N) {
        int[] res = new int[N+1];
        res[0] = 0; res[1] = 1;
        
        for (int i = 2; i <= N; i++) {
            res[i] = res[i-1] + 1;
            for (int j = 3; j <= i - 1; j++) {
                res[i] = Math.max(res[i], (j - 1) * res[i - j]);
            }
        }
        
        return res[N];
    }
}