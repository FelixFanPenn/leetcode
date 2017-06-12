public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }
    
    public void dfs(int[][] rooms, int i, int j, int dist){
        if (i >= rooms.length || i < 0 || j >= rooms[0].length || j < 0 || dist > rooms[i][j]) return;
        rooms[i][j] = dist++;
        dfs(rooms, i-1, j, dist);
        dfs(rooms, i+1, j, dist);
        dfs(rooms, i, j-1, dist);
        dfs(rooms, i, j+1, dist);
    }
}