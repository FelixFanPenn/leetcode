public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int i = 0, j = 0;
        while (i < s.length) {
            i = j;
            while (i < s.length && s[i] == ' ') i++;
            if (i == s.length) break;
            j = i;
            while (j < s.length && s[j] != ' ') j++;
            reverse(s, i, j-1);
        }
    }
    
    public void reverse(char[] s, int start, int end){
        while (start < end){
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }
}