public class Solution {
    public List<String> removeInvalidParentheses(String s) {
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
}

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
      List<String> res = new ArrayList<>();
      
      // sanity check
      if (s == null) return res;
      
      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      
      // initialize
      queue.add(s);
      visited.add(s);
      
      boolean reached = false;
      
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String cur = queue.remove();
            // Valid
            if (isValid(cur)) {
                reached = true;
                res.add(cur);
            }
            // Not Valid Then Delete 
            if (!reached) {
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;
                    String newStr = cur.substring(0, j) + cur.substring(j + 1);
                    if (!visited.contains(newStr)) {
                        queue.add(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        if (reached) break;
    }
      
      return res;
    }
    
    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
      int count = 0;
    
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }
    
      return count == 0;
    }
}

/*
In BFS we handle the states level by level, in the worst case, we need to handle all the levels, 
we can analyze the time complexity level by level and add them up to get the final complexity.

On the first level, there's only one string which is the input string s, let's say the length of it is n, 
to check whether it's valid, we need O(n) time. On the second level, we remove one ( or ) from the first level, 
so there are C(n, n-1) new strings, each of them has n-1 characters, and for each string, 
we need to check whether it's valid or not, thus the total time complexity on this level is (n-1) x C(n, n-1). 
Come to the third level, total time complexity is (n-2) x C(n, n-2), so on and so forth...

Finally we have this formula:

T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).

*/