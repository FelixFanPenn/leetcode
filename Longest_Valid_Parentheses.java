/*
public class Solution {
    public int longestValidParentheses(String s) {   //use a stack
        Stack<Integer> stack = new Stack<>();
        int left = -1;
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            } else {
                if (stack.isEmpty()){
                    left = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()){
                        maxlen = Math.max(maxlen, i-left);
                    } else {
                        maxlen = Math.max(maxlen, i-stack.peek());
                    }
                }
            }
        }
        return maxlen;
    }
}

*/
public class Solution {
    public int longestValidParentheses(String s) {   //use DP
        int[] dp = new int[s.length()];
        int open = 0, maxlen = 0;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')' && open > 0){
                dp[i] = 2 + dp[i-1];   // each () will add 2 to the length
                if (i - dp[i] > 0){    // if there is valid () from previous string
                    dp[i] += dp[i-dp[i]];  // this may be zero so nothing is added to dp[i]
                }
                
                maxlen = Math.max(maxlen, dp[i]);
                open--;
            }
        }
        return maxlen;
    }
}
