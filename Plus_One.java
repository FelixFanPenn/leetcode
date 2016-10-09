public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length-1;
        int c = 1, digit = 0;
        for (int i = len; i >= 0; i--){
            digit = (digits[i] + c) % 10;
            c = (digits[i] + c) / 10;
            digits[i] = digit;
        }
        if (c == 1){
            int[] tmp = new int[digits.length+1];
            tmp[0] = 1;
            for (int i = 0; i <= len; i++){
                tmp[i+1] = digits[i];
            }
            return tmp;
        } else {
            return digits;
        }
    }
}
