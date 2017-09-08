public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length-1;
        int r = 0, c = col;
        
        while (r < row && c >= 0) {
            if (target == matrix[r][c]) return true;
            else if (target > matrix[r][c]) r++;
            else c--;
        }
        
        return false;
    }
}