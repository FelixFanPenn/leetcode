class Solution {
    public int calculateMinimumHP(int[][] d) {
        int row = d.length, col = d[0].length;
        int[][] dp = new int[row][col];
        
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                if (i == row-1 && j == col-1) {
                    dp[i][j] = Math.max(1 - d[i][j], 1);
                } else if (i == row-1) {
                    dp[i][j] = Math.max(dp[i][j+1] - d[i][j], 1);
                } else if (j == col-1) {
                    dp[i][j] = Math.max(dp[i+1][j] - d[i][j], 1);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i][j+1] - d[i][j], dp[i+1][j] - d[i][j]));
                }
            }
        }
        return dp[0][0];
    }
}