public class Solution {
    public void rotate(int[][] matrix) {
        int[] row = new int[matrix[0].length];
        int len = matrix.length;
        for (int i = 0; i < len/2; i++){
            row = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = row; 
        }
        
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
