class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        return backtrack(pattern, 0, str, 0, map, set);
    }
    
    public boolean backtrack(String pattern, int p, String str, int s, Map<Character, String> map, Set<String> set) {
        if (p == pattern.length() && s == str.length()) return true;
        if (p == pattern.length() || s == str.length()) return false;
        
        char c = pattern.charAt(p);
        if (map.containsKey(c)) {
            String value = map.get(c);
            if (!str.startsWith(value, s)) return false;        // if the str starts with value at index s!!!!
            return backtrack(pattern, p + 1, str, s + value.length(), map, set);
        } else {
            
            // if have never met this char before, search every possible char-string mapping
            for (int i = s; i < str.length() - pattern.length() + p + 1; i++) {     // the mapping string cannot be so long that rest of chars don't have string to match
                String tmp = str.substring(s, i+1);
                if (set.contains(tmp)) continue;
                map.put(c, tmp);
                set.add(tmp);
                
                if (backtrack(pattern, p + 1, str, i + 1, map, set)) return true;
                map.remove(c);
                set.remove(tmp);
            }
        }
        return false;
    }
}