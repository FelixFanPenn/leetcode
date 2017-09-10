class Solution {

    
    int[] x = new int[] {0, 0, 1, -1};
    int[] y = new int[] {1, -1, 0, 0};
    
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) return 0;
        List<int[]> list = new ArrayList<>();
        int step = 0, row = forest.size(), col = forest.get(0).size();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) {
                    list.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }
        if (list.size() == 0) return 0;
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare (int[] p1, int[] p2) {
                return p1[2] - p2[2];
            }
        });
        
        int[] cur = new int[] {0, 0};
        
        for (int[] p : list) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(cur);
            
            int tmp = getSteps(q, p, forest, new boolean[row][col], row, col);
            if (tmp == -1) return -1;
            step += tmp;
            
            cur = new int[] {p[0], p[1]};
        }
        return step;
    }
    
    public int getSteps (Queue<int[]> q, int[] p, List<List<Integer>> forest, boolean[][] visited, int row, int col) {
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == p[0] && cur[1] == p[1]) return step;
                visited[cur[0]][cur[1]] = true;
                
                for (int j = 0; j < 4; j++) {
                    int n1 = x[j] + cur[0];
                    int n2 = y[j] + cur[1];
                    
                    if (n1 < 0 || n1 >= row || n2 < 0 || n2 >= col) continue;
                    if (forest.get(n1).get(n2) == 0 || visited[n1][n2]) continue;
                    visited[n1][n2] = true;
                    q.offer(new int[] {n1, n2});
                }
                
            }
            step++;
        }
        return -1;
    }
}