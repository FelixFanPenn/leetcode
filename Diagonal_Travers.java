public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int row = matrix.length, col = matrix[0].length;
        int x = 0, y = 0, len = row * col, i = 0;
        int[] res = new int[len];
        boolean up = true;
    
        while (i < len) {
            res[i++] = matrix[x][y];
            
            if (up) {
                x--; y++;
                if (x < 0) {
                    x = 0;
                    up = false;
                }
                if (y == col) {
                    y = col - 1;
                    x += 2;
                    if (!up) x--;
                    up = false;
                }
            } else {
                x++; y--;
                if (y < 0) {
                    y = 0;
                    up = true;
                }
                if (x == row) {
                    x = row - 1;
                    y += 2;
                    if (up) y--;
                    up = true;
                }
            }
        }
        return res;
    }
}