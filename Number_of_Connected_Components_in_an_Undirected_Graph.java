public class Solution {
    public int countComponents(int n, int[][] edges) {
        /*
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        
        int res = n;
        for (int i = 0; i < edges.length; i++) {
            int x = find(arr, edges[i][0]);
            int y = find(arr, edges[i][1]);
            if (x != y) {
                res--;
                arr[y] = x;
            }
        }
        
        return res;
        */
        
        List<List<Integer>> list = new ArrayList<>();
        int ret = 0;
        boolean[] res = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!res[i]) {
                dfs(res, list, i);
                ret++;    
            }
        }
        return ret;
    }
    
    public void dfs(boolean[] res, List<List<Integer>> list, int index) {
        if (res[index]) return;
        res[index] = true;
        for (int i = 0; i < list.get(index).size(); i++) {
            dfs(res, list, list.get(index).get(i));
        }
    }
    
    /*
    public int find(int[] arr, int x) {
        while (arr[x] != x) {
            x = arr[x];
        }
        return x;
    }
    */
}