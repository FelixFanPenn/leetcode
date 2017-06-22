public class Solution {
    public int findMinMoves(int[] machines) {
        int len = machines.length, total = 0;
        for (int i : machines) {
            total += i;
        }
        if (total % len != 0) return -1;
        
        int max = 0, cnt = 0, avg = total/len;
        for (int i = 0; i < len; i++) {
            cnt += machines[i] - avg;
            max = Math.max(max, Math.max(Math.abs(cnt), machines[i] - avg));
        }
        return max;
    }
}