public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = s.charAt(0) == '0'? 0:1;
        
        for (int i = 2; i <= s.length(); i++){
            int tmp = Integer.parseInt("" + s.charAt(i-1));
            if (tmp != 0){
                res[i] = res[i-1];
            }
            int temp = Integer.parseInt("" + s.charAt(i-2) + s.charAt(i-1));
            if (temp <= 26 && temp >= 10){
                res[i] += res[i-2];
            }
        }
        
        return res[s.length()];
    }
}
