public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        
        boolean neg = false;
        if (num < 0) {
            num = -num;
            neg = true;
        }
        String str = "";
        
        while (num != 0){
            int digit = num % 7;
            num /= 7;
            str = digit + str;
        }
        
        return neg ? '-'+str : str;
    }
}
