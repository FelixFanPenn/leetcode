public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : s.split(" ")){
            sb.append((new StringBuilder(str)).reverse().toString());
            sb.append(" ");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
}