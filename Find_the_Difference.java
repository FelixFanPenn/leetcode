public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);  
            }
        }
        
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if (!map.containsKey(c)){
                return c;
            } else {
                map.put(c, map.get(c)-1);
            }
        }
        
        for (char c : map.keySet()){
            if (map.get(c) != 0) return c;
        }
        return ' ';
    }
}
