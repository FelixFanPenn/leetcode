public class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int lena = a.length(), lenb = b.length();
        int bita = 0, bitb = 0, c = 0;
        
        while (lena > 0 || lenb > 0){
            bita = lena > 0 ? a.charAt(lena-1)-'0' : 0 ;
            bitb = lenb > 0 ? b.charAt(lenb-1)-'0' : 0 ;
            
            int sum = bita + bitb + c;
            if (sum == 3) {
                c = 1;
                res = '1' + res;
            } else if (sum == 2) {
                c = 1;
                res = '0' + res;
            } else if (sum == 1) {
                c = 0;
                res = '1' + res;
            } else {
                c = 0;
                res = '0' + res;
            }
            lena--;
            lenb--;
        }
        if (c == 1) res = '1' + res;
        return res;
    }
}