public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c) return nums;
        
        int[][] res = new int[r][c];
        int dx = 0, dy = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[dx][dy++];
                if (dy == col) {
                    dy = 0;
                    dx++;
                }
            }
        }
        return res;
    }
}