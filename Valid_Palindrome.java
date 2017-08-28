public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        if (s.length() < 2) return true;
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left >= right) return true;
            
            char l = s.charAt(left), r = s.charAt(right);
            if (l == r) {
                left++; right--;
            } else {
                return false;
            }
        }
        return true;
    }
}