public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] res = new int[row][col];
        boolean flag = true; 
        
        for (int i = 0; i < row; i++){
            if (obstacleGrid[i][0] == 1){
                res[i][0] = 0;
                flag = false;
            } else if (flag){
                res[i][0] = 1;
            } else {
                res[i][0] = 0;
            }
        }
        flag = true;
        
        for (int j = 0; j < col; j++){
            if (obstacleGrid[0][j] == 1){
                res[0][j] = 0;
                flag = false;
            } else if (flag){
                res[0][j] = 1;
            } else {
                res[0][j] = 0;
            }
        }
        
        
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                if (obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i][j-1] + res[i-1][j];
                }
                
            }
        }
        return res[row-1][col-1];
    }
}
