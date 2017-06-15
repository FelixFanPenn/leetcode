public class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int m = i+dx[k], n = j+dy[k];
                    if (m >= 0 && m < row && n >= 0 && n < col && (board[m][n] == 1 || board[m][n] == 2)) {
                        count++;
                    }
                }
                
                if (board[i][j] == 1 && (count > 3 || count < 2)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                } 
            }
        }
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                board[i][j] %= 2;
            }
        }
        
    }
}