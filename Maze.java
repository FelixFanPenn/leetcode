import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    static int[] x = {0, 0, 1, -1};
    static int[] y = {1, -1, 0, 0};
    public static int solution (int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        if (matrix[0][0] == 9) return 1;
        if (matrix[0][0] == 0) return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (matrix[cur[0]][cur[1]] == 9) return 1;
            if (matrix[cur[0]][cur[1]] == 0) continue;
            
            for (int i = 0; i < 4; i++) {
                int a = cur[0] + x[i];
                int b = cur[1] + y[i];
                if (a < 0 || a >= matrix.length) continue;
                if (b < 0 || b >= matrix[0].length) continue;
                int[] next = new int[]{a, b};
                queue.offer(next);
            }
            matrix[cur[0]][cur[1]] = 0;
        }
        return 0;   
    }
}
