public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        int left = 0, right = 0;
        
        for (int i = 0; i < s.length()-1; i++){
            int tmp1 = expandAroundCenter(s, i, i);
            int tmp2 = expandAroundCenter(s, i, i+1);
            int tmp = Math.max(tmp1, tmp2);
            
            if (right-left < tmp){
                left = i - (tmp-1)/2;
                right = i + tmp/2;
            }
        }
        return s.substring(left, right+1);
    }
    
    private int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        return right - left - 1;
    }
}
