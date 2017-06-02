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