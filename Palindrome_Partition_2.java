public class Solution {
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] res = new int[len];
        boolean[][] bools = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            res[i] = i;
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (chars[i] == chars[j] && (i - 1 <= j + 1 || bools[j+1][i-1])) {
                    bools[j][i] = true;
                    if (j == 0) {
                        res[i] = 0;
                    } else {
                        res[i] = Math.min(res[i], 1 + res[j-1]);
                    }
                }
            }
        }
        
        return res[len-1];
    }
}