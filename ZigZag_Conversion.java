public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        String res = "";
        int size = 2 * numRows - 2;
        
        for (int i = 0; i < numRows; i++){
            for (int j = i; j < s.length(); j += size){
                res += s.charAt(j);
                int tmp = j + size - 2 * i;
                if (i != 0 && i != numRows-1 && tmp < s.length()) {
                    res += s.charAt(tmp);
                }
            }
        }
        return res;
    }
}
/*
public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) sb[i] = new StringBuffer();
        int i = 0, len = s.length();
        
        while(i < len){
            for (int idx = 0; i < len && idx < numRows; idx++){   // vertically down
                sb[idx].append(s.charAt(i++));
            }
            for (int idx = numRows-2; i < len && idx >= 1; idx--){ // obliquely up
                sb[idx].append(s.charAt(i++));
            }
        }
        
        for (int j = 1; j < sb.length; j++){
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}
*/