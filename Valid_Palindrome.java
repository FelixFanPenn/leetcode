public class Solution {
    public boolean isPalindrome(String s) {
        return isPalin(preProcess(s));
    }
    
    private String preProcess(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private boolean isPalin(String s){
        if ("".equals(s)){
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
