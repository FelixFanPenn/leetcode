public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0 , 0);
    }
    
    public boolean solveSudoku(char[][] board, int i, int j){
        if (i == 9) return true;
        if (j == 9) return solveSudoku(board, i+1, 0);
        if (board[i][j] != '.') return solveSudoku(board, i, j+1);
        else {
            for (int k = 1; k < 10; k++){
                board[i][j] = (char)('0' + k);
                if (isValid(board, i, j)) {
                    if (solveSudoku(board, i, j+1)) return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int i, int j){
        for (int col = 0; col < 9; ++col) {
            if (col != j && board[i][j] == board[i][col]) return false;
        }
        for (int row = 0; row < 9; ++row) {
            if (row != i && board[i][j] == board[row][j]) return false;
        }
        
        for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++){
            for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++){
                if ((m != i || n != j) && board[i][j] == board[m][n]){
                    return false;
                }
            }
        }
        return true;
    }
}