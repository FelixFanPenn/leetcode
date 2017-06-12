public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        /*
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, len = 0;
        
        while (r < s.length()) {
            if (map.size() <= k) {
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
            if (map.size() <= k) len = Math.max(len, r-l);
        }
        return len;
        */
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int best = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);                     
                    if (map.get(leftChar) == 0) { 
                        map.remove(leftChar);
                    }
                }
                left++;
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    }
}