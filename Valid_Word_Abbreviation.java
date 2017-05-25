public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int lenw = word.length(), lena = abbr.length(), i = 0, j = 0;
        while (i < lenw && j < lena){
            
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
            
        }
        
        return i == lenw && j == lena;
    }
}