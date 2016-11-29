public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int start = 0;
        
        while(start + 1 < row){
            int mid = start + (row - start)/2;
            if (matrix[mid][0] > target){
                row = mid;
            } else if (matrix[mid][0] == target){
                return true;
            } else {
                start = mid;
            }
        }
        int row_end = 0;
        if (matrix[row][0] <= target) row_end = row;
        else if (matrix[start][0] <= target) row_end = start;
        
        row = matrix.length - 1; start = 0;
        while(start + 1 < row){
            int mid = start + (row - start)/2;
            if (matrix[mid][col] >= target){
                row = mid;
            } else if (matrix[mid][col] == target){
                return true;
            } else {
                start = mid;
            }
        }
        int row_start = 0;
        if (matrix[start][col] <= target) row_start = start;
        else if (matrix[row][col] <= target) row_start = row;
        
        for (int i = row_start; i <= row_end; i++){
            int left = 0, right = matrix[i].length - 1;
            while(left + 1 < right){
                int mid = left + (right - left)/2;
                if (matrix[i][mid] == target){
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid; 
                } else {
                    left = mid;
                }
            }
            if (matrix[i][left] == target || matrix[i][right] == target) {
                return true;
            }
        }
        return false;
    }
}
