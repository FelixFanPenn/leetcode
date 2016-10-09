public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1, count = 1;
        
        while(true){
            for (int i = left; i <= right; i++){
                res[top][i] = count++;
            }
            top++;
            if (top > bottom) break;
            
            for (int i = top; i <= bottom; i++){
                res[i][right] = count++;
            }
            right--;
            if (left > right) break;
            
            for (int i = right; i >= left; i--){
                res[bottom][i] = count++;
            }
            bottom--;
            if (top > bottom ) break;
            
            for (int i = bottom; i >= top; i--){
                res[i][left] = count++;
            }
            left++;
            if (left > right) break;
        }
        return res;
    }
}
