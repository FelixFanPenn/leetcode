public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int startRow = findStartRow(matrix, target);
        int endRow = findEndRow(matrix, target);
        int startCol = findStartCol(matrix, target);
        int endCol = findEndCol(matrix, target);
        
        if (startRow == -1 || endRow == -1 || startCol == -1 || endCol == -1) {
            return true;
        }
        
        if (startRow > endRow || startCol > endCol) {
            return false;
        }
        
        for (int i = startRow; i <= endRow ; i++){
            int s = startCol; int e = endCol;
            while (s + 1 < e){
                int mid = (s + e) /2;
                
                if (matrix[i][mid] == target){
                    return true;
                } else if (matrix[i][mid] > target){
                    e = mid;
                } else {
                    s = mid;
                }
            }
            
            if (matrix[i][s] == target || matrix[i][e] == target){
                return true;
            }
        }
        return false;
    
    }
    
    public int findStartRow(int[][] matrix, int target){
        int col = matrix[0].length - 1;
        int start = 0; int end = matrix.length - 1;
        
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (matrix[mid][col] == target){
                return -1;
            } else if (matrix[mid][col] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (matrix[start][col] >= target){
            return start;
        }
        return end;
        
    }
    
    public int findEndRow(int[][] matrix, int target){
        int start = 0; int end = matrix.length - 1;
        
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (matrix[mid][0] == target){
                return -1;
            } else if (matrix[mid][0] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (matrix[end][0] <= target){
            return end;
        }
        return start;
    }
    
    public int findStartCol(int[][] matrix, int target){
        int row = matrix.length - 1;
        int start = 0; int end = matrix[0].length - 1;
        
        
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (matrix[row][mid] == target){
                return -1;
            } else if (matrix[row][mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (matrix[row][start] >= target){
            return start;
        }
        return end;
    }
    
    public int findEndCol(int[][] matrix, int target){
        int start = 0; int end = matrix[0].length - 1;
        
        
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (matrix[0][mid] == target){
                return -1;
            } else if (matrix[0][mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (matrix[0][end] <= target){
            return end;
        }
        return start;
    }
}


/*
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
*/
