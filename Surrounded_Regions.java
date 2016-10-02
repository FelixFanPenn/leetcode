public class Solution {
    int row, col;
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        row = board.length; col = board[0].length;
  
        int dummyNode = row * col;
        UnionFind uf = new UnionFind(row * col + 1);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (board[i][j] == 'O'){
                    if (i == 0 || i == row-1 || j == 0 || j == col-1) {
                        uf.union(node(i, j), dummyNode);
                    } else {
                        if (i > 0 && board[i-1][j] == 'O') uf.union(node(i, j), node(i-1, j));
                        if (i < row && board[i+1][j] == 'O') uf.union(node(i, j), node(i+1, j));
                        if (j > 0 && board[i][j-1] == 'O') uf.union(node(i, j), node(i, j-1));
                        if (j < col && board[i][j+1] == 'O') uf.union(node(i, j), node(i, j+1));
                    }
                }
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (uf.isConnected(node(i, j), dummyNode)){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public int node(int i, int j) {
        return i * col + j;
    }
    
    public class UnionFind{
        int[] parent;
        public UnionFind(int totalNodes){
            parent = new int[totalNodes+1];
            for (int i = 0; i < totalNodes; i++){
                parent[i] = i;
            }
        }
        
        public boolean isConnected(int node1, int node2){
            return find(node1) == find(node2);
        }
        
        public int find(int node){
            while(node != parent[node]){
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        
        public void union(int node1, int node2){
            int n1 = find(node1);
            int n2 = find(node2);
            if (n1 != n2){
                parent[n2] = n1;
            }
        }
    }
}
