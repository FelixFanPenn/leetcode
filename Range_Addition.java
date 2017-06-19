public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length+1];
        int[] ret = new int[length];
        /*
        TLE solution
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            
            for (int j = start; j <= end; j++) {
                res[j] += val;
            }
            
        }
        */
        
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            
            res[start] += val;
            res[end+1] -= val;
                
        }
        
        for (int i = 1; i < length+1; i++) {
            res[i] += res[i-1];
        }
        
        for (int i = 0; i < length; i++) {
            ret[i] = res[i];
        }
        
        return ret;
    }
}