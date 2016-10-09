public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];
        char[] str = s.toCharArray();
        for (char c : str){
            arr[c - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        
        for (char c : str){
            arr[c - 'a']--;
            if (visited[c - 'a']) continue;
                 // stack is not empty    // the previous char has a same copy after 
            while(!stack.isEmpty() && arr[stack.peek() - 'a'] > 0 && stack.peek() > c){
                                                                    // the previous char is larger
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            
            stack.push(c);
            visited[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
