public class Solution {
    public int longestPalindrome(String s) {
        if (s.equals("")) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        
        boolean addOne = false;
        int len = 0;
        for (char c : map.keySet()){
            if (map.get(c) % 2 == 0){
                len += map.get(c);
            } else {
                len += map.get(c)/2 * 2;
                addOne = true;
            }
        }
        return addOne ? 1+len : len;
    }
}
