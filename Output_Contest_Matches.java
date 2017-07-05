public class Solution {
    public String findContestMatch(int n) {
        String[] strs = new String[n];
        for (int i = 1; i <= n; i++) {
            strs[i-1] = "" + i;
        }
        
        /*
        while (n != 1) {
            for (int i = 0; i < n; i++) {
                strs[i] = "(" + strs[i] + "," + strs[n - i - 1] + ")";
            }
            n /= 2;
        }
        return strs[0];
        */
        helper(strs, n);
        return strs[0];
    }
    
    public void helper(String[] strs, int n) {
        if (n == 1) return;
        for (int i = 0; i < n; i++) {
            strs[i] = "(" + strs[i] + "," + strs[n - i - 1] + ")";
        }
        helper(strs, n/2);
    }
    
}