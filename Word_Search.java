public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        
        if(word == null || word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (backtrack(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int row, int col, int len, String word){
        if (word.length() == len) return true;
        
        if(row < 0 || row == board.length || col < 0 || col == board[0].length) {
            return false;
        }
        
        if (board[row][col] == word.charAt(len)){
            board[row][col] = ' ';
            len++;
            boolean res = backtrack(board, row+1, col, len, word) || 
                          backtrack(board, row-1, col, len, word) || 
                          backtrack(board, row, col+1, len, word) || 
                          backtrack(board, row, col-1, len, word);
            board[row][col] = word.charAt(len-1);
            return res;
        } else {
            return false;
        }
    }
}
