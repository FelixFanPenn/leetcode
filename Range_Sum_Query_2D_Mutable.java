public class NumMatrix {
    
    static int[][] nums;
	static int[][] BIT;
	static int row;
	static int col;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        row = matrix.length;
        col = matrix[0].length;
        nums = new int[row][col];
        BIT = new int[row+1][col+1];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                update(i, j, matrix[i][j]);
                System.out.print(BIT[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public void update(int r, int c, int val) {
    	if (row == 0 || col == 0) return;
        int dif = val - nums[r][c];
        nums[r][c] = val;
    	
        for (int i = r + 1; i <= row; i += (i & -i)) {
            for (int j = c + 1; j <= col; j += (j & -j)) {
                BIT[i][j] += dif;
            }
        }
    }
    
    public int getSum(int r, int c) {
    	int sum = 0;
        for (int i = r; i > 0; i -= (i & -i)) {
            for (int j = c; j > 0; j -= (j & -j)) {
                sum += BIT[i][j];
            }
        }
        return sum;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (row == 0 || col == 0) return 0;
    	return getSum(row2+1, col2+1) + getSum(row1, col1) - getSum(row2+1, col1) - getSum(row1, col2+1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */