public class Solution {
    public int countComponents(int n, int[][] edges) {  /// DFS beats 37%
        if (n <= 1){
            return n;
        }   
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
                dfs(visited, adj, i);
            }
        }
        return count;
    }
    
    private void dfs(boolean[] visited, List<List<Integer>> adj, int num){
        visited[num] = true;
        for (int i : adj.get(num)){
            if (!visited[i]){
                dfs(visited, adj, i);
            }
        }
    }
    
    /*   BFS
    public int countComponents(int n, int[][] edges) {
        if (n <= 1){
            return n;
        }   
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                while (!queue.isEmpty()){
                    int tmp = queue.poll();
                    visited[tmp] = true;
                    for (Integer j : adj.get(tmp)){
                        if (!visited[j]){
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
    
    */
    /*   my own version that beats 0.65%
    public int countComponents(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++){
            if (visited.contains(i)) continue;
            if (unionFind(edges, i, visited)){
                count++;
            }
        }
        return count - visited.size() + n;
    }
    
    private boolean unionFind(int[][] edges, int num, Set<Integer> visited){
        int next = 0;
        int cur = 0;
        boolean found = false;
        for (int i = 0; i < edges.length; i++){
            if (num == edges[i][0] || num == edges[i][1]){
                cur = edges[i][0];
                next = edges[i][1];
                visited.add(cur);
                visited.add(next);
                edges[i][0] = -1;
                edges[i][1] = -1;
                found = true;
                unionFind(edges, cur, visited);
                unionFind(edges, next, visited);
            }
        }
        return found;
    }
    */
}
