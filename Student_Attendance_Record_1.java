public class Solution {
    public boolean checkRecord(String s) {
        int l = 0, a = 0, cur = 0;
        for (char c : s.toCharArray()){
            if (c == 'A') {
                a++;
                cur = 0;
                if (a > 1) return false;
                continue;
            }
            if (c == 'L'){
                cur++;
                if (cur > 2) return false;
                
            } else {
                cur = 0;
            }
        }
        return true;
    }
}
