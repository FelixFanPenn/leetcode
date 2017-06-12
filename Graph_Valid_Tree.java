public class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        for (int i = 0; i < edges.length; i++) {
            int a = find(res, edges[i][0]);
            int b = find(res, edges[i][1]);
            if (a == b) return false;
            
            res[a] = b;
        }
        return edges.length == n-1;
    }
    
    public int find(int[] nums, int num){
        if (nums[num] != -1) return find(nums, nums[num]);
        else return num;
    }
}