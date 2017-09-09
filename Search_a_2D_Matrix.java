public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length, col = matrix[0].length;
        int right = row * col - 1, left = 0;
        
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int r = mid / col;
            int c = mid % col;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
