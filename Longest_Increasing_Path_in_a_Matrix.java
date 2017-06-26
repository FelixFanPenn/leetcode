public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int[] res = new int[1];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(matrix, dp, res, i, j);
            }
        }
        
        return res[0];
    }
    
    public int dfs(int[][] matrix, int[][] dp, int[] res, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int[][] xy = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int max = 0;
        
        for (int k = 0; k < 4; k++) {
            int dx = i + xy[k][0];
            int dy = j + xy[k][1];
            if (dx < 0 || dx >= matrix.length || dy < 0 || dy >= matrix[0].length) continue;
            if (matrix[i][j] >= matrix[dx][dy]) continue;
            max = Math.max(dfs(matrix, dp, res, dx, dy), max);
        }
        
        dp[i][j] = 1 + max;
        res[0] = Math.max(res[0], dp[i][j]);
        return dp[i][j];
    }
}