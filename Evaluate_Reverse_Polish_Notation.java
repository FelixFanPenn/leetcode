public class Solution {
    public int evalRPN(String[] tokens) {
        String[] op = {"-", "+", "/", "*"};
        Set<String> s = new HashSet<>();
        s.add("-"); s.add("+"); s.add("/"); s.add("*");
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        while (i != tokens.length){
            
            if (s.contains(tokens[i])){
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                if (tokens[i].equals(op[0])){
                    c = a - b;
                }
                else if (tokens[i].equals(op[1])){
                    c = a + b;
                }
                else if (tokens[i].equals(op[2])){
                    c = a / b;
                }
                else {
                    c = a * b;
                }
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.pop();
    }
}
