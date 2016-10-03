public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (t.length() == 0 || s.length() == 0) return res;
    
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            if (tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }
        
        int left = 0, minLen = s.length()+1, minLeft = 0, count = 0;
        for (int right = 0; right < s.length(); right++){
            if (tMap.containsKey(s.charAt(right))){
                
                tMap.put(s.charAt(right), tMap.get(s.charAt(right))-1);
                
                if (tMap.get(s.charAt(right)) >= 0){
                    count++;
                }
                
                while(count == t.length()){
                    if (right - left + 1 < minLen){
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    
                    if (tMap.containsKey(s.charAt(left))){
                        tMap.put(s.charAt(left), tMap.get(s.charAt(left))+1);
                        
                        if (tMap.get(s.charAt(left)) > 0){
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen == s.length()+1) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}
