class Solution {
    public int maximumSwap(int num) {
        char[] digits = ("" + num).toCharArray();
        int[] buckets = new int[10];
        
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) { // if the digit is larger than current digit
                if (buckets[j] > i) {               // if the position is behind current digit
                    char c = digits[i];
                    digits[i] = (char)('0' + j);
                    digits[buckets[j]] = c;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}