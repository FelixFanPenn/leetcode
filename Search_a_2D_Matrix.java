public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int startRow = 0; int endRow = matrix.length - 1;
        int mid;
        
        while (startRow + 1 < endRow){
            mid = (startRow + endRow) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) endRow = mid;
            else startRow = mid;
        }
        
        if (matrix[endRow][0] <= target) {
            startRow = endRow;
        } 
        if (matrix[startRow][0] > target) {
            return false;
        }
        
        
        int startColumn = 0; int endColumn = matrix[0].length - 1;
        
        while (startColumn + 1 < endColumn){
            int midColumn = (startColumn + endColumn) / 2;
            if (matrix[startRow][midColumn] == target){
                return true;
            } else if (matrix[startRow][midColumn] > target){
                endColumn = midColumn;
            } else {
                startColumn = midColumn;
            }
        }
        
        return matrix[startRow][startColumn] == target || matrix[startRow][endColumn] == target ;
        
    }
}
