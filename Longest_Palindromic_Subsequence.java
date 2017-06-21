public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] res = new int[len][len];
        
        for (int i = len-1; i >= 0; i--) {
            res[i][i] = 1;
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    res[i][j] = res[i+1][j-1] + 2;
                } else {
                    res[i][j] = Math.max(res[i+1][j], res[i][j-1]);
                }
            }
        }
        return res[0][len-1];
    }
}