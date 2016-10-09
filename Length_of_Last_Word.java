public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.equals("")) return 0;
        String[] str = s.trim().split(" ");
        int len = str.length;
        return str[len-1].length();
    }
}
