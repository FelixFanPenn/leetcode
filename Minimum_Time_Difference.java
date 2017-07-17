public class Solution {
    public int findMinDifference(List<String> t) {
        int len = t.size(), first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        int[] time = new int[len];
        boolean[] times = new boolean[24 * 60];
        for (int i = 0; i < t.size(); i++) {
            String[] tmp = t.get(i).split(":");
            int s = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            
            first = Math.min(s, first);
            last = Math.max(s, last);
            
            if (times[s]) return 0;
            times[s] = true;
        }
        
        int res = Integer.MAX_VALUE, pre = -1;
        
        for (int i = 0; i < 24 * 60; i++) {
            if (times[i]) {
                if (pre != -1) {
                    res = Math.min(res, i - pre);
                }
                pre = i;
            }
        }
        
        return Math.min(res, 24 * 60 + first - last);
    }
}