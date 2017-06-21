public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        } else {
            dfs(board, x, y);
        }
        return board;
    }
    
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        String chars = "012345678";
        int[][] tmp = {{0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}, {-1, 1}, {-1, -1}, {-1, 0}};
        if (board[x][y] == 'B' || chars.indexOf(board[x][y]) != -1) {
            return;
        } else {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int dx = x + tmp[i][0];
                int dy = y + tmp[i][1];
                if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length){
                    if (board[dx][dy] == 'M') count++;
                }
            }
            if (count == 0) {
                
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++) {
                    int dx = x + tmp[i][0];
                    int dy = y + tmp[i][1];
                    dfs(board, dx, dy);
                }
            } else {
                board[x][y] = chars.charAt(count);
                return;
            }
        }
    }
}