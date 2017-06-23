public class Solution {
    public int findPoisonedDuration(int[] time, int d) {
        if (time.length == 0) return 0;
        int res = d, cur = d + time[0];
        
        for (int i = 1; i < time.length; i++) {
            res += d;
            if (time[i] < cur) {
                res -= (cur - time[i]);
            }
            cur = time[i] + d;
        }
        
        return res;
        
    }
}