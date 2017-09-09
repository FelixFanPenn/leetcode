public class MaximumMinimumPath {
    private static int max = Integer.MIN_VALUE;
    public static int maxMinPath(int[][] matrix) {
        dfs(matrix, Integer.MAX_VALUE, 0, 0);
        return max;
    }
    
    public static void dfs(int[][] matrix, int curmin, int r, int c) {
        if (r == matrix.length-1 && c == matrix[0].length-1) {
            max = Math.max(max, curmin);
            return;
        }
        
        if (r >= matrix.length || c >= matrix[0].length) return;
        
        dfs(matrix, Math.min(curmin, matrix[r][c]), r+1, c);
        dfs(matrix, Math.min(curmin, matrix[r][c]), r, c+1);
    }
}
