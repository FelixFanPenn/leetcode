public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        
        Stack<Character> stack1 = new Stack<>();
        Set<Character> left = new HashSet<Character>(); 
        left.add('['); left.add('{'); left.add('(');
        Set<Character> right = new HashSet<Character>();
        right.add(']'); right.add('}'); right.add(')');
        
        for (char c : s.toCharArray()){
            if (left.contains(c)){
                stack1.push(c);
            }
            if (right.contains(c)){
                if (stack1.isEmpty()) return false;
                char tmp = stack1.pop();
                if (tmp == '[' && c == ']' || tmp == '(' && c == ')' || tmp == '{' && c == '}' ){
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack1.isEmpty();
    }
}
