public class Solution {
    public int calculateMinimumHP(int[][] dun) {
        int row = dun.length;
        if (row == 0) return 0;
        int col = dun[0].length;
        
        int[][] health = new int[row][col];
        health[row-1][col-1] = Math.max(1, 1 - dun[row-1][col-1]);
        
        for (int i = row-2; i >= 0; i--) {
            health[i][col-1] = Math.max(1, health[i+1][col-1] - dun[i][col-1]);
        }
        
        for (int i = col-2; i >= 0; i--) {
            health[row-1][i] = Math.max(1, health[row-1][i+1] - dun[row-1][i]);
        }
        
        for (int i = row-2; i >= 0; i--) {
            for (int j = col-2; j >= 0; j--) {
                int right = Math.max(1, health[i][j+1] - dun[i][j]);
                int down = Math.max(1, health[i+1][j] - dun[i][j]);
                health[i][j] = Math.min(right, down);
            }
        }
        return health[0][0];
    }
}