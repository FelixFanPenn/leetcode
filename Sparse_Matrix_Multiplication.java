public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowa = A.length, rowb = B.length, cola = A[0].length, colb = B[0].length;
        int[][] res = new int[rowa][colb];
        
        for (int i = 0; i < rowa; i++){
            for (int j = 0; j < cola; j++){
                if (A[i][j] == 0){
                    continue;
                } else {
                    for (int k = 0; k < colb; k++){
                        res[i][k] += A[i][j] * B[j][k];
                    }
                } 
            }
        }
        return res;
    }
}