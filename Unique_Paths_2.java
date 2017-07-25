public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int[] res = new int[col];
        res[0] = 1;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) res[j] = 0;
                else {
                    if (j > 0) res[j] += res[j-1];
                }
            }
        }
        return res[col-1];
    }
}