public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        // match[i][j] means if s.substring(i) and p.substring(j) matches.

        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                        match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                        match[i][j]=match[i+1][j]||match[i][j+1];
                        // in this case, if s.substring(i+1) matched p.substring(j)
                    // or s.substring(i) matched p.substring(j+1), it is true
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {

        int starIdx = -1, match = 0, sIdx = 0, pIdx = 0;
        while (sIdx < s.length()){
            if (pIdx < p.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?')) {
                sIdx++; pIdx++;
            } else if (pIdx < p.length() && p.charAt(pIdx) == '*'){
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            } else {
                if (starIdx != -1) {
                    pIdx = starIdx + 1;
                    match++; sIdx = match;
                } else {
                    return false;
                }
            }
        }
        
        while (pIdx < p.length() && p.charAt(pIdx) == '*') pIdx++; 
        
        return pIdx == p.length();
    
    }
}