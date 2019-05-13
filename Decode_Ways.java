public class Solution {
    /*
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
    */

    class Solution {
    public int numDecodings(String s) {
        int len = s.length(), secondLast = 1;
        int last = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int newLast = c =='0' ? 0 : last;
            String tmp = s.substring(i-1, i+1);
            int val = Integer.valueOf(tmp);
            if (val <= 26 && val >= 10) {
                newLast += secondLast;
            }
            secondLast = last;
            last = newLast;
        }
        return last;
    }
}

}
