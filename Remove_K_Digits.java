public class Solution {
    public String removeKdigits(String num, int k) {
        
        int len = num.length();
        if (len <= k) return "0";
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < len) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                k--;
                stack.pop();
            }
            stack.push(c);
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}