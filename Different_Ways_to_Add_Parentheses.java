/*
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String leftStr = input.substring(0, i);
                String rightStr = input.substring(i + 1);
                List<Integer> leftList = diffWaysToCompute(leftStr);
                List<Integer> rightList = diffWaysToCompute(rightStr);
                
                for (Integer l : leftList){
                    for (Integer r : rightList){
                        if (c == '+'){
                            result.add(l + r);
                        } else if (c == '-'){
                            result.add(l - r);
                        } else {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        if (result.size() == 0){
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
*/


public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<String, List<Integer>>());
    }
    
    private List<Integer> dfs(String input, HashMap<String, List<Integer>> map){
        if (map.containsKey(input)) return map.get(input);
        
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String leftStr = input.substring(0, i);
                String rightStr = input.substring(i + 1);
                
                List<Integer> leftList = dfs(leftStr, map);
                List<Integer> rightList = dfs(rightStr, map);
                
                for (Integer l : leftList){
                    for (Integer r : rightList){
                        int result = 0;
                        if (c == '+'){
                            result = l + r;
                        } else if (c == '-'){
                            result = l - r;
                        } else {
                            result = l * r;
                        }
                        res.add(result);
                    }
                }
            }
        }
        if (res.size() == 0){
            res.add(Integer.parseInt(input));
        }
        
        map.put(input, res);
        return res;
    }
}

