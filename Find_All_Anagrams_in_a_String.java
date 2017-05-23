public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lens = s.length(), lenp = p.length();
        List<Integer> list = new ArrayList<>();
        if (lens < lenp) return list;
        
        int[] chars = new int[26];
        for (char c : p.toCharArray()){
            chars[c-'a']++;
        }
        int numDiff = lenp, i = 0, left = 0;
        
        for (i = 0; i < lenp; i++){
            char c = s.charAt(i);
            if (chars[c-'a'] > 0){
                numDiff--;
            }
            chars[c-'a']--;
        }
        
        if (numDiff == 0) list.add(0);
        
        while (i < lens) {
            char c = s.charAt(left++);
            if (chars[c-'a'] >= 0) numDiff++;
            chars[c-'a']++;
            
            c = s.charAt(i++);
            chars[c-'a']--;
            if (chars[c-'a'] >= 0) numDiff--;
            
            if (numDiff == 0) list.add(left);
            
        }
        
        return list;
    }
}