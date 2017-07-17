public class Solution {
    
    int[][] diff = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(m <= 0 || n <= 0) return res;

        int[] uf = new int[m * n];
        Arrays.fill(uf, -1);
        int count = 0;
        
        for (int[] tmp : positions) {
            int root = tmp[0] * n + tmp[1];
            uf[root] = root;
            count++;
            
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + diff[i][0];
                int y = tmp[1] + diff[i][1];
                int nb = n * x + y;
                
                if (x < 0 || y < 0 || x >= m || y >= n || uf[nb] == -1) continue;
                
                int rootNb = findRoot(uf, nb);
                
                if (root != rootNb) {
                    uf[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
        
    }
    
    public int findRoot(int[] uf, int root) {
        while (root != uf[root]) {
            uf[root] = uf[uf[root]];
            root = uf[root];
        }
        return root;
    }
}