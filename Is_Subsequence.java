public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen > tLen){
            return false;
        }
        int prev = 0;
        
        for (int i = 0; i < sLen; i++){
            char tmp = s.charAt(i);
            prev = t.indexOf(tmp, prev);
            if (prev == -1) return false;
            prev++;
        }
        return true;
    }
}
