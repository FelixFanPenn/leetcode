public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, len = 0;
        
        while (r < s.length()) {
            if (map.size() <= 2) {
                char c = s.charAt(r++);
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c)+1);
                }
            } else {
                char c = s.charAt(l++);
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c)-1);
                }
            }
            if (map.size() <= 2) len = Math.max(len, r-l);
        }
        return len;
    }
}