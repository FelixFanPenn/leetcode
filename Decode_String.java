public class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder cur = new StringBuilder();
        int num = 0;
        
        for (char c : arr){
            if (Character.isDigit(c)){
                num = 10 * num + (c - '0');
            } else if (c == '['){
                intStack.push(num);
                strStack.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (c == ']'){
                StringBuilder tmp = cur;
                cur = strStack.pop();
                int i = intStack.pop();
                for (int j = 0; j < i; j++){
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }
        
        return cur.toString();
        
    }
}
