public class Solution {
    public final int[] DIRECTIONS = {0, 1, 0, -1, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] startHere = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, startHere);
    }
    
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] startHere) {
        if (Arrays.equals(start, destination)) return true;
        if (startHere[start[0]][start[1]]) return false;
        startHere[start[0]][start[1]] = true;
        
        for (int i = 0; i < 4; i++) {
            int[] newStart = roll(maze, start[0], start[1], DIRECTIONS[i], DIRECTIONS[i+1]);
            if (dfs(maze, newStart, destination, startHere)) return true;
            
        }
        return false;
    }
    
    public boolean canRoll(int[][] maze, int row, int col) {
        if (row < 0 || row >= maze.length ||
            col < 0 || col >= maze[0].length) return false;
        if (maze[row][col] == 1) return false;
        return true;
    }
    
    public int[] roll(int[][] maze, int row, int col, int rowInc, int colInc) {
        while (canRoll(maze, row+rowInc, col+colInc)) {
            row += rowInc;
            col += colInc;
        }
        return new int[]{row, col};
    }
    
}