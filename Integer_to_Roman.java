public class Solution {
    
    private static final int[] values = {
    1000, 900, 500, 400,
    100,  90,  50,  40,
    10,   9,   5,   4,
    1 };
    private static final String[] symbols = {
    "M", "CM", "D", "CD",
    "C", "XC", "L", "XL",
    "X", "IX", "V", "IV",
    "I"
    };
    
    public String intToRoman(int num) {
        String res = "";
        for (int i = 0; i < values.length; i++){
            if (num / values[i] > 0) {
                for (int j = 0; j < num / values[i]; j++) {
                    res += symbols[i];
                }
                num %= values[i];
            }
        }
        return res;
    }
}