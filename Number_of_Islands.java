class Solution {
    // dfs no recursion. m * n
    private final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 'i';
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }
    
    private void dfs (char[][] grid, int row, int col) {
        //grid[row][col] = 'i';
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{row, col});
        while (!s.isEmpty()) {
            int[] cur = s.pop();
            for (int i = 0; i < 4; i++) {
                int nextRow = cur[0] + DIRECTIONS[i][0];
                int nextCol = cur[1] + DIRECTIONS[i][1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                if (grid[nextRow][nextCol] == '1') {
                    grid[nextRow][nextCol] = 'i';
                    s.push(new int[] {nextRow, nextCol});
                }
            }
        }
    }
    
    // time complexity: m*n m is the len and n is height.
    private final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    bfs(grid, i, j);
                }
            }
        }
        return num;
    }
    
    private void bfs (char[][] grid, int row, int col) {
        grid[row][col] = 'i';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = cur[0] + DIRECTIONS[i][0];
                int nextCol = cur[1] + DIRECTIONS[i][1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                if (grid[nextRow][nextCol] == '1') {
                    grid[nextRow][nextCol] = 'i';
                    q.offer(new int[] {nextRow, nextCol});
                }
            }
        }
    }
    
    
    // dfs recursion. time complexity m * n
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    helper(grid, i, j);
                }
            }
        }
        return cnt;
    }
    
    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        // can add more if else to prune branches
        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid, i, j+1);
        helper(grid, i, j-1);
    }

}