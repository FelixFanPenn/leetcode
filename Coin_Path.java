public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] cost = new int[n]; // cost
        int[] pre = new int[n]; // previous index
        int[] len = new int[n]; // length
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(pre, -1);
        cost[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) continue;
            for (int j = Math.max(0, i - B); j < i; j++) {
                if (A[j] == -1) continue;
                int tmp = cost[j] + A[i];
                if (tmp < cost[i] || tmp == cost[i] && len[i] < len[j]+1) {
                    cost[i] = tmp;
                    pre[i] = j;
                    len[i] = 1+len[j];
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        for (int i = n-1; i >= 0; i = pre[i]) {
            path.add(0, i+1);
        }
        return path.get(0) != 1 ? Collections.emptyList() : path;
    }
}