public class Solution {
    public String simplifyPath(String path) {
        String res = "";
        Stack<String> stack = new Stack<>();
        int len = path.length(), i = 0;
        while (i < len){
            while (i < len && path.charAt(i) == '/') i++;
            if (i == len) break;
            int start = i;
            while (i < len && path.charAt(i) != '/') i++;
            int end = i;
            
            String tmp = path.substring(start, end);
            if (tmp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!tmp.equals(".")) {
                stack.push(tmp);
            }
            
        }
        if (stack.size() == 0) return "/";
        while (stack.size() != 0){
            res = '/' + stack.pop() + res;
        }
        return res;
    }
}