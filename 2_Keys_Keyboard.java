public class Solution {
    public int minSteps(int n) {
        if (n <= 1) return 0;
        int[] res = new int[n+1];
        
        for (int i = 2; i <= n; i++) {
            res[i] = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    res[i] = Math.min(res[i], j + res[i / j]);
                }
            }
        }
        return res[n];
    }
}