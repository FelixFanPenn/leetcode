class Solution {
    
    // this works for 256 different chars, fast O(n)
   public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j)]++;
            if (count[s.charAt(j)] == 1) num++;
            if (num > k) {
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
    
    //this works for all unicode chars, slow O(n)
    /*
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
    */
}