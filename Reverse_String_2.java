public class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        boolean b = true;
        
        for (int i = 0; i < len;){
            if (b) {
                if (i + k <= len) {
                    String str = (new StringBuilder(s.substring(i, i+k))).reverse().toString();
                    sb.append(str);
                    i += k;
                    b = false;
                } else {
                    String str = (new StringBuilder(s.substring(i, len))).reverse().toString();
                    sb.append(str);
                    break;
                }
            } else {
                if (i + k <= len) {
                    sb.append(s.substring(i, i+k));
                    i += k;
                    b = true;
                } else {
                    sb.append(s.substring(i, len));
                    break;
                }
            }
        }       
        
        
        return sb.toString();
    }
}