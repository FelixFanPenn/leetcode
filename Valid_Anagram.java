public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++){
            if (sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);    // how to update values in a hashmap
            } else {
                sMap.put(s.charAt(i), 1);
            }
            if (tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }
        return sMap.equals(tMap);    // compare two maps and test if they are the same
    }
}
