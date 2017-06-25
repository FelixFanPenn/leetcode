public class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int[] chars = new int[256];
        boolean[] visited = new boolean[256];
        
        for (char c : s.toCharArray()) {
            chars[c]++;
        }
        
        for (char c : s.toCharArray()) {
            chars[c]--;
            if (visited[c]) continue;
            while (!stack.isEmpty() && chars[stack.peek()] > 0 && stack.peek() > c) {
                visited[stack.pop()] = false;
            }
            stack.push(c);
            visited[c] = true;
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}