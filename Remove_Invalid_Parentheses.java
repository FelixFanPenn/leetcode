public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        boolean found = false;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        
        while(!queue.isEmpty()){
            String tmp = queue.poll();
            if (isValid(tmp)){
                found = true;
                res.add(tmp);
            }
            
            if (found) continue;
            
            for (int i = 0; i < tmp.length(); i++){   // generate all possible states
                if (tmp.charAt(i) == '(' || tmp.charAt(i) == ')'){
                    String newStr = tmp.substring(0, i) + tmp.substring(i+1);
                    if (!visited.contains(newStr)){  //add it to the queue if not visited
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return res;
    }
    
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
}
