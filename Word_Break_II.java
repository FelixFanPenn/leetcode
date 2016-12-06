public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }
    
    private LinkedList<String> dfs(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map){
        if (map.containsKey(s)){
            return map.get(s);
        }
        
        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0){
            res.add("");
            return res;
        }
        
        
        for (String str : wordDict){
            if (s.startsWith(str)){
                LinkedList<String> sublist = dfs(s.substring(str.length()), wordDict, map);
                for (String string : sublist){
                    res.add(str + (string.equals("")? "" : " ") + string);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
