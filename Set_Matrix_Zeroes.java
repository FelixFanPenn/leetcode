public class Solution {
    public void setZeroes(int[][] matrix) {
        
        
        int row = matrix.length, col = matrix[0].length;
        int col0 = 1;
        
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
        
    }
}
/*
public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        List<Integer> r = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    r.add(i);
                    c.add(j);
                }
            }
        }
        
        for (int i = 0; i < r.size(); i++){
            for (int j = 0; j < col; j++){
                matrix[r.get(i)][j] = 0;
            }
        }
        
        for (int i = 0; i < c.size(); i++){
            for (int j = 0; j < row; j++){
                matrix[j][c.get(i)] = 0;
            }
        }
        
        
    }
}
*/
