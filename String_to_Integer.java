public class Solution {
    public int myAtoi(String str) {
        int res = 0;
        int i = 0;
        boolean isMinus = false;
        boolean hasSign = false;
        str = str.trim();
        int len = str.length();
        if (str.length() == 0) return 0;
        if (str.charAt(0) == '-'){
            isMinus = true;
            hasSign = true;
        } else if (str.charAt(0) == '+'){
            isMinus = false;
            hasSign = true;
        } else if (str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            isMinus = false;
            hasSign = false;
        } else {
            return 0;
        }
        
        if (hasSign){
            i = 1;
        }
        while (i < len){
            char c = str.charAt(i);
            if (c >= '0' && c <= '9'){
                int tmp = res;
                res = 10 * res + c - '0';
                if (tmp != res/10) {
                    if (isMinus){
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
            i++;
        }
        if (isMinus)
            return -res; 
        else return res;
    }
}
