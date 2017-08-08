public class Solution {
    class Position implements Comparable<Position>{
        public int r;
        public int c;
        public int steps;
    
        public Position(int r, int c, int s){
            this.r=r;
            this.c=c;
            this.steps=s;
        }
    
        @Override
        public int compareTo(Position other){
            return this.steps-other.steps;
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        
        int[] dirs = {0, 1, 0, -1, 0};
        int[][] minSteps = new int[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                minSteps[i][j] = Integer.MAX_VALUE;
            }
        }
        
        boolean right = canRoll(maze, dest[0] + dirs[0], dest[1] + dirs[1]);
        boolean down = canRoll(maze, dest[0] + dirs[1], dest[1] + dirs[2]);
        boolean left = canRoll(maze, dest[0] + dirs[2], dest[1] + dirs[3]);
        boolean up = canRoll(maze, dest[0] + dirs[3], dest[1] + dirs[4]);
        if (right && left && up && down) return -1;
        if (!right && !left && up && down) return -1;
        if (right && left && !up && !down) return -1;
        if (!right && !left && !up && !down) return -1;
        
        minSteps[start[0]][start[1]] = 0;
        /*BFS; Optimization: use PriorityQueue based on the steps instead of Queue*/
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(start[0], start[1], 0));
        
        while (!pq.isEmpty()) {
            Position pos = pq.poll();
            if (pos.r == dest[0] && pos.c == dest[1]) return pos.steps;
            
            for(int i = 0; i < 4; i++) {
                int r = pos.r, c = pos.c, currSteps = 0;
                while (canRoll(maze, r+dirs[i], c+dirs[i+1])) {
                    r += dirs[i];
                    c += dirs[i+1];
                    currSteps++;
                }
                int totalSteps = pos.steps + currSteps;
                if (totalSteps < minSteps[r][c] && totalSteps < minSteps[dest[0]][dest[1]]) {
                    minSteps[r][c] = totalSteps;
                    pq.offer(new Position(r, c, totalSteps));
                }
            }
        }
        
        return minSteps[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : minSteps[dest[0]][dest[1]];
    }
    
    public boolean canRoll(int[][] maze, int row, int col) {
        if (row < 0 || row >= maze.length ||
            col < 0 || col >= maze[0].length) return false;
        if (maze[row][col] == 1) return false;
        return true;
    }
    
}