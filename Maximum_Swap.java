class Solution {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int i = chars.length;
        int[] digits = new int[i];
        
        for (int j = 0; j < i; j++) {
            digits[j] = chars[j] - '0';
        }
        
        boolean b = true;
        for (int j = 0; j < i; j++) {
            if (j < i-1 && digits[j] < digits[j+1]) {
                b = false;
                break;
            }
        }
        if (b) return num;
        
        for (int j = 0; j < i; j++) {
            int max = Integer.MIN_VALUE, index = -1;;
            for (int k = j; k < i; k++) {
                if (max <= digits[k]) {
                    max = digits[k];
                    index = k;
                }
            }
            
            if (digits[j] != max) {
                int tmp = digits[j];
                digits[j] = digits[index];
                digits[index] = tmp;
                break;
            }
        }
        
        int res = 0;
        for (int v : digits) {
            res = 10 * res + v;
        }
        return res;
    }
}