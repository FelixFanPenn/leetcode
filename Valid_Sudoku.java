public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    for (int k = 0; k < 9; k++){
                        if(board[i][j] == board[i][k] && j!=k) return false;
                    }
                    for (int k = 0; k < 9; k++){
                        if(board[k][j] == board[i][j] && i!=k) return false;
                    }
                }
            }
        }
        
        for (int i = 1; i <= 7; i += 3){
            for (int j = 1; j <= 7; j += 3){
                Set<Character> set = new HashSet<>();
                set.clear();
                set.add(board[i][j]);
                for (int k = -1; k <= 1; k++){
                    for (int l = -1; l <= 1; l++){
                        if (board[i+k][j+l] != '.'){
                            if (set.contains(board[i+k][j+l]) && (!(k == 0 && l == 0))){
                                return false;
                            } else {
                                set.add(board[i+k][j+l]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
