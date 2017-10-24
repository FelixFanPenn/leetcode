public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] chars = new int[26];
        
        for (int i = 0; i < len1; i++){
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        if (isArrayAllZero(chars)) return true;
        int left = 0;
        for (int i = len1; i < len2; i++){
            chars[s2.charAt(left++) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
            if (isArrayAllZero(chars)) return true;
        }
        return false;
    }
    
    public boolean isArrayAllZero(int[] chars){
        for (int i : chars){
            if (i != 0) return false;
        }
        return true;
    }
}

/*
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
    
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c) >= 0) cnt++;
            }
        }
        if (cnt == s1.length()) return true;
        int left = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            char c1 = s2.charAt(i);
            char c2 = s2.charAt(left++);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1)-1);
                if (map.get(c1) >= 0) cnt++;
            }
            if (map.containsKey(c2)) {
                map.put(c2, map.get(c2)+1);
                if (map.get(c2) > 0) cnt--;
            }
            if (cnt == s1.length()) return true;
        }
        
        return false;
    }
}
*/