public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1'){
                    count++;
                    unionFind(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void unionFind(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return;
        
        if (grid[i][j] == '1'){
            grid[i][j] = '0';
            unionFind(grid, i-1, j);
            unionFind(grid, i, j-1);
            unionFind(grid, i+1, j);
            unionFind(grid, i, j+1);
        }
    }
}
