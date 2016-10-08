public class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");  // all the spaces in between
        String res = "";
        for (int i = str.length-1; i >= 0; i--){
            res += str[i].trim() + " ";
        }
        return res.trim();
    }
}
