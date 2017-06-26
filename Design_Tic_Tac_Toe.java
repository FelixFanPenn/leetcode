public class TicTacToe {
    
    int[] rows;
    int[] cols;
    int diag;
    int revD;
    int len;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        revD = 0;
        len = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = (player == 1) ? 1 : -1;
        if (row == col) {
            diag += val;
            if (diag == len) return 1;
            if (diag == -len) return 2;
        }
        
        if (row + col == len - 1) {
            revD += val;
            if (revD == len) return 1;
            if (revD == -len) return 2;
        }
        
        rows[row] += val;
        if (rows[row] == len) return 1;
        if (rows[row] == -len) return 2;
        
        cols[col] += val;
        if (cols[col] == len) return 1;
        if (cols[col] == -len) return 2;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */