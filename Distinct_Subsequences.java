public class Solution {
    public int numDistinct(String s, String t) {
        int lens = s.length(), lent = t.length();
        
        int[][] res = new int[lens+1][lent+1];
        
        for (int i = 0; i <= lens; i++){
            res[i][0] = 1;
        }
        
        for (int i = 1; i <= lens; i++){
            for (int j = 1; j <= lent; j++){
                res[i][j] = res[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)){
                    res[i][j] += res[i-1][j-1];
                }
            }
        }
        return res[lens][lent];
    }
}