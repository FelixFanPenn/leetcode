public class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] res = new int[len];
        res[0] = 1;
        
        for (int i = 1; i < len; i++) {
            res[i] += res[i-1];
            for (int j = 0; j <= i; j++) {
                if (isPalin(s, j, i)) res[i]++;
            }
        }
        return res[len-1];
    }
    
    public boolean isPalin(String str, int start, int end) {
        while (start < end && str.charAt(start) == str.charAt(end)) {
            start++; end--;
        }
        return start >= end;
    }
}