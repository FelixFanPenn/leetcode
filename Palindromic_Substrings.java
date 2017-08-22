public class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            search(s, i, i+1);
            search(s, i, i);
        }
        return count;
    }
    
    public void search(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}