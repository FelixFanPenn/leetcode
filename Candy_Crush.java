class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return board;
        int r = board.length, c = board[0].length;
        while (true) {
            boolean shouldContinue = false;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c - 2; j++) {
                    int v = Math.abs(board[i][j]);
                    if (v != 0 && v == Math.abs(board[i][j+1]) && v == Math.abs(board[i][j+2])) {
                        board[i][j] = board[i][j+1] = board[i][j+2] = -v;
                        shouldContinue = true;
                    }
                }
            }
            for (int i = 0; i < r-2; i++) {
                for (int j = 0; j < c; j++) {
                    int v = Math.abs(board[i][j]);
                    if (v != 0 && v == Math.abs(board[i+1][j]) && v == Math.abs(board[i+2][j])) {
                        board[i][j] = board[i+1][j] = board[i+2][j] = -v;
                        shouldContinue = true;
                    }
                }
            }
            
            if (!shouldContinue)
                break;
            for (int i = 0; i < c; i++) {
                int row = r-1;
                for (int j = r-1; j >= 0; j--) {
                    if (board[j][i] > 0) {
                        board[row--][i] = board[j][i];
                    }
                }
                for (int j = row; j >= 0; j--) {
                    board[j][i] = 0;
                }
            }
        }
        return board;
    }
}