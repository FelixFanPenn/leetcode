class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length, col = M[0].length;
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0, num = 0;
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <= j+1; l++) {
                        if (k >= 0 && l >= 0 && k <= row-1 && l <= col-1) {
                            sum += M[k][l];
                            num++;
                        }
                    }
                }
                nums[i][j] = sum / num;
            }
        }
        return nums;
    }
}
