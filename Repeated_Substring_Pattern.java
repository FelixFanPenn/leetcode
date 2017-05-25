public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        
        for (int i = 1; i <= len / 2; i++){
            if (len % i != 0) continue;
            int j = i;
            String sub = s.substring(0, j);
            while (j < len){
                int t = j+i;
                String tmp = s.substring(j, t);
                if (!tmp.equals(sub)) break;
                j = t;
            }
            if (j == len) return true;
        }
        return false;
    }
}