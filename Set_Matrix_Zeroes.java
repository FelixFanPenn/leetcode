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
