public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++){
            if (sMap.containsKey(s.charAt(i)) == tMap.containsKey(t.charAt(i))){
                if (sMap.containsKey(s.charAt(i)) == false){
                    sMap.put(s.charAt(i), i);
                    tMap.put(t.charAt(i), i);
                } else {
                    if (sMap.get(s.charAt(i)) != tMap.get(t.charAt(i))) 
                        return false;
                }
            } else return false;
        }
        return true;
    }
}
