public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length(), len = len1 + len2 - 2;
        int[] res = new int[len1+len2];
        
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                res[len-i-j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int c = 0;
        for (int i = 0; i < len1+len2; i++){
            res[i] += c;
            c = res[i] / 10;
            res[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        len = len1 + len2 - 1;
        while (len >= 0 && res[len] == 0) --len;
        if (len < 0) return "0";
        while (len >= 0) sb.append(res[len--]);
        return sb.toString();
    }
}