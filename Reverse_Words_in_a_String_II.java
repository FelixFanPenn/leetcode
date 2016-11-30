public class Solution {
    public void reverseWords(char[] s) {
        int right = s.length-1;
        int first = 0;
        reverse(s, 0, right);
        for (int i = 0 ; i < s.length; i++){
            if (s[i] == ' '){
                reverse(s, first, i-1);
                first = i + 1;
            } else if (i == s.length-1){
                reverse(s, first, i);
            }
        }
    }
    
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }
}
