public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length) return false;
        HashMap<Character, Integer> patMap = new HashMap<Character, Integer>();
        HashMap<String, Integer> strMap = new HashMap<String, Integer>();
        
        for (int i = 0; i < pattern.length(); i++){
            if (patMap.containsKey(pattern.charAt(i)) && strMap.containsKey(strArr[i])){
                if (patMap.get(pattern.charAt(i)) != strMap.get(strArr[i])) return false;
            } else if (!patMap.containsKey(pattern.charAt(i)) && !strMap.containsKey(strArr[i])){
                patMap.put(pattern.charAt(i), i);
                strMap.put(strArr[i], i);
            } else return false;
            
        }
        return true;
    }
}
