public class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";
        while (num != 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }
        
        return words.trim();
    }
    
    public String helper(int tmp) {
        if (tmp == 0) return "";
        if (tmp < 20) return LESS_THAN_20[tmp] + " ";
        if (tmp < 100) return TENS[tmp/10] + " " + helper(tmp % 10);
        return LESS_THAN_20[tmp/100] + " Hundred " + helper(tmp % 100);
    }
}