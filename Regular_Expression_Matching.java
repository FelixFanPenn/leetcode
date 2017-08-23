public class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length(), lenp = p.length();
        boolean[][] res = new boolean[lens+1][lenp+1];
        res[0][0] = true;
        
        for (int i = 0; i < lenp; i++) {
            if (p.charAt(i) == '*' && i > 0 && res[0][i-1]) 
                res[0][i+1] = true;
        }
        
        for (int i = 0; i < lens; i++) {
            for (int j = 0; j < lenp; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    res[i+1][j+1] = res[i][j];
                } 
                if (p.charAt(j) == '*'){
                    if (j > 0 && s.charAt(i) != p.charAt(j-1) && p.charAt(j-1) != '.') {
                        res[i+1][j+1] = res[i+1][j-1];
                    } else {
                        res[i+1][j+1] = (j > 0 ? res[i+1][j-1] : false) || res[i+1][j] || res[i][j+1];
                        
                                                // a* becomes empty       a* becomes a    a* becomes multiple a (expand a)     
                    }
                }
            }
        }
        
        return res[lens][lenp];
    }
}