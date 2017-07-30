public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays.size() <= 1) return 0;
        int len = arrays.size(), curmax = arrays.get(0).get(0), curmin = arrays.get(0).get(0), res = Integer.MIN_VALUE;
        int[] max = new int[len]; Arrays.fill(max, Integer.MIN_VALUE);
        int[] min = new int[len]; Arrays.fill(min, Integer.MAX_VALUE);
        
        for (int i = 0; i < len; i++) {
            
            for (int j : arrays.get(i)) {
                
                if (i == 0) {
                    curmax = Math.max(curmax, j);
                    curmin = Math.min(curmin, j);
                    continue;
                }
                
                max[i] = Math.max(max[i], j);
                min[i] = Math.min(min[i], j);
            }
            if (i == 0) continue;
            
            res = Math.max(Math.max(res, curmax - min[i]), max[i] - curmin);
            curmax = Math.max(curmax, max[i]);
            curmin = Math.min(curmin, min[i]);
        }
        return res;
    }
}