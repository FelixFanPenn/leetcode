class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++; right--;
            } else {
                return isPalin(s.substring(0, left) + s.substring(left+1)) ||
                     isPalin(s.substring(0, right) + s.substring(right+1));
            }
        }
        return true;
    }
    
    public boolean isPalin (String s) {
        int left = 0, right = s.length()-1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++; right--;
        }
        return left >= right;
    }
}