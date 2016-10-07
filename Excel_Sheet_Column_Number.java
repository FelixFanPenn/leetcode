public class Solution {
    public int titleToNumber(String s) {
        int res = 0, base = 1;
        
        for (int i = s.length()-1; i >= 0; i--){
            int digit = s.charAt(i) - 'A' + 1;
            res += digit * base;
            base *= 26;
        }
        return res;
    }
}
