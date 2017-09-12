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

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j)]++;
            if (count[s.charAt(j)] == 1) num++;
            if (num > 2) {
                count[s.charAt(i)]--;
                while (count[s.charAt(i++)] > 0) {
                    count[s.charAt(i)]--;
                }
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}