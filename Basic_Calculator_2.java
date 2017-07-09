public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length(), num = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = (10 * num + c - '0');
            }
            if (i == len - 1 || (!Character.isDigit(c) && ' ' != c)) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);  
                }
                sign = c;
                num = 0;
            }
        }
        
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}