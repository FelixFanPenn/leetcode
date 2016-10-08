public class Solution {
    public int numDistinct(String s, String t) {
        int lens = s.length(), lent = t.length();
        int[][] res = new int[lens+1][lent+1];  //res[i][j] means how many distinct subseq between s.substring(0, i) and t.substring(0, j)

        for (int i = 1; i <= lens; i++){
            res[i-1][0] = 1;
        }
        for (int i = 2; i <= lent; i++){
            res[0][i-1] = 0;
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
