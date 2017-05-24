public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.toLowerCase().equals(word) || word.toUpperCase().equals(word)) return true;
        if (word.charAt(0) <= 'Z' && word.charAt(0) >= 'A') {
            for (int i = 1; i < word.length(); i++){
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
            return true;
        } else {
            return false;
        }
    }
}