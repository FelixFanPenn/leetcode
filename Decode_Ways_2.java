public class Solution {
    public int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        if(s.length() < 2) return (int)res[0];
        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        
        for (int i = 2; i < s.length(); i++) {
            long tmp = res[1];
            res[1] = (res[1] * ways(s.charAt(i)) + res[0] * ways(s.charAt(i-1), s.charAt(i))) % 1000000007;
            res[0] = tmp;
        }
        return (int)res[1];
    }
    
    public int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }
    
    public int ways(char c1, char c2) {
        String str = "" + c1 + c2;
        if (c1 == '*' && c2 == '*') return 15;
        if (c1 != '*' && c2 != '*') {
            if (Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        }
        if (c1 == '*') {
            if (Integer.parseInt("" + c2) >= 0 && Integer.parseInt("" + c2) <= 6) return 2;
            else  return 1;
        } else if (c2 == '*') {
            if (Integer.parseInt("" + c1) == 1) return 9;
            if (Integer.parseInt("" + c1) == 2) return 6;
        }
        return 0;
    }
}