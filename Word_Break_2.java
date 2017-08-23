class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    
    public List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        
        for (String str : wordDict) {
            if (str.length() == 0) continue;
            if (s.startsWith(str)) {
                List<String> tmp = dfs(s.substring(str.length()), wordDict, map);
                for (String e : tmp) {      // tmp may contain 0 or 1 word
                    list.add(str + (e.isEmpty() ? "" : " ") + e);
                }
            }
        }
        
        map.put(s, list);
        return list;
    }
}