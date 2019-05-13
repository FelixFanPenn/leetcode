class Solution {
    
    /*
    Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, 
    where in each step you can delete one character in either string.
    */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? 
                           dp[i-1][j-1] + 1 : 
                           Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        // dp[len1][len2] is the longest common subsequence
        // To make them identical, just find the longest common subsequence. 
        // The rest of the characters have to be deleted from the both the strings, 
        // which does not belong to longest common subsequence.
        
        return len1 + len2 - 2 * dp[len1][len2];
    }
}