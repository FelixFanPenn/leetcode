public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        /*
        Limit max removal rmL and rmR for backtracking boundary. Otherwise it will exhaust all possible valid substrings, not shortest ones.
        Scan from left to right, avoiding invalid strs (on the fly) by checking num of open parens.
        If it's '(', either use it, or remove it.
        If it's '(', either use it, or remove it.
        Otherwise just append it.
        Lastly set StringBuilder to the last decision point.

        */

        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') rmL++;
            else if (s.charAt(i) == ')') {
                if (rmL == 0) rmR++;
                else rmL--;
            }
        }
        Set<String> res = new HashSet<>();
        dfs(new StringBuilder(), rmL, rmR, 0, res, s, 0);
        
        return new ArrayList<>(res);
        
        /* BFS simple but slow
        List<String> list = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
         
        while (!q.isEmpty()) {
            String tmp = q.poll();
            if (isValid(tmp)) {
                list.add(tmp);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '(' || tmp.charAt(i) == ')') {
                    String str = tmp.substring(0, i) + tmp.substring(i+1);
                    if (!visited.contains(str)) {
                        q.offer(str);
                        visited.add(str);
                    }
                }
            }
            
        }
        return list;
        */
    }
    
    public void dfs(StringBuilder sb, int rmL, int rmR, int open, Set<String> set, String s, int len) {
        if (rmL < 0 || rmR < 0 || open < 0) return;
        if (len == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                set.add(sb.toString());
            }
            return;
        }
        int size = sb.length();
        char c = s.charAt(len);
        
        if (c == '(') {
            dfs(sb, rmL-1, rmR, open, set, s, len+1);
            dfs(sb.append(c), rmL, rmR, open+1, set, s, len+1);
        } else if (c == ')') {
            dfs(sb, rmL, rmR-1, open, set, s, len+1);
            dfs(sb.append(c), rmL, rmR, open-1, set, s, len+1);
        } else {
            dfs(sb.append(c), rmL, rmR, open, set, s, len+1);
        }
        sb.setLength(size);
    }
    
    /*
    private boolean isValid(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') count++;
            else if (str.charAt(i) == ')'){
                if (count != 0){
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }
    */
}