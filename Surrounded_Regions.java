public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++){
            if (board[i][0] == 'O'){
                bfs(board, i, 0, row, col);
            }
            if (board[i][col-1] == 'O'){
                bfs(board, i, col-1, row, col);
            }
        }
        
        for (int i = 0; i < col; i++){
            if (board[0][i] == 'O'){
                bfs(board, 0, i, row, col);
            }
            if (board[row-1][i] == 'O'){
                bfs(board, row-1, i, row, col);
            }
        }
        /*
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    //if (board[i][j] == 'O') dfs(board, i , j);
                    if (board[i][j] == 'O') bfs(board, i, j, row, col);
                }
            }   
        }
        */
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '$') board[i][j] = 'O';
            }
        }
        
    }
    
    /*
    public void dfs(char[][] board, int i, int j){
        int row = board.length, col = board[0].length;
        if (i < 0 || i >= row) return;
        if (j < 0 || j >= col) return;
        if (board[i][j] == 'O') board[i][j] = '$';
        if (i-1 >= 0 && board[i-1][j] == 'O') dfs(board, i-1, j); 
        if (i+1 < row && board[i+1][j] == 'O') dfs(board, i+1, j);
        if (j-1 >= 0 && board[i][j-1] == 'O') dfs(board, i, j-1); 
        if (j+1 < col && board[i][j+1] == 'O') dfs(board, i, j+1);
        return;
    }
    */
    
    public void bfs(char[][] board, int i, int j, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        board[i][j] = '$';
        int[] pair = {i, j};
        q.offer(pair);
        
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            i = tmp[0]; j = tmp[1];
            if (i-1 >= 0 && board[i-1][j] == 'O') {
                board[i-1][j] = '$';
                int[] pair1 = {i-1, j};
                q.offer(pair1);
            }
            if (i+1 < row && board[i+1][j] == 'O') {
                board[i+1][j] = '$';
                int[] pair2 = {i+1, j};
                q.offer(pair2);
            }
            if (j-1 >= 0 && board[i][j-1] == 'O') {
                board[i][j-1] = '$';
                int[] pair3 = {i, j-1};
                q.offer(pair3);
            }
            if (j+1 < col && board[i][j+1] == 'O') {
                board[i][j+1] = '$';
                int[] pair4 = {i, j+1};
                q.offer(pair4);
            }
        }
    }
}