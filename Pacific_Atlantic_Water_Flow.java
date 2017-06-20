public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        
        List<int[]> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];
        
        
        for (int i = 0; i < row; i++) {
            dfs(matrix, pac, i, 0, Integer.MIN_VALUE);
            dfs(matrix, atl, i, col-1, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < col; i++) {
            dfs(matrix, pac, 0, i, Integer.MIN_VALUE);
            dfs(matrix, atl, row-1, i, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pac[i][j] && atl[i][j]) {
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    list.add(tmp);
                }
            }
        }
        
        return list;
    }
    
    public void dfs(int[][] matrix, boolean[][] bools, int x, int y, int height) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || bools[x][y] || height > matrix[x][y]) {
            return;
        }
        bools[x][y] = true;
        
        dfs(matrix, bools, x, y-1, matrix[x][y]);
        dfs(matrix, bools, x, y+1, matrix[x][y]);
        dfs(matrix, bools, x-1, y, matrix[x][y]);
        dfs(matrix, bools, x+1, y, matrix[x][y]);
    }
}